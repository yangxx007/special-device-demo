package com.example.demo.web;

import com.example.demo.config.DatabaseForDataConfig;
import com.example.demo.entity.dataModel.ApplyInfo;
import com.example.demo.entity.dataModel.ApplyStatus;
import com.example.demo.enums.ApplyConditions;
import com.example.demo.enums.CustomePage;
import com.example.demo.enums.JsonResponse;
import com.example.demo.enums.MyPage;
import com.example.demo.Dao.apply.ApplySearchCondition;
import com.example.demo.responseModel.ApplyResponse;
import com.example.demo.service.ApplyService;
import com.example.demo.service.UserStatusService;
import com.example.demo.service.exception.ValidateFailException;
import com.example.demo.service.staticfunction.UtilServiceImpl;
import com.example.demo.service.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.apache.shiro.SecurityUtils;
import org.hibernate.annotations.Source;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.Date;
/**
 * @author yang
 * @create_at 2017/10/17
 **/
@Controller
@RequestMapping("/apply")

public class ApplyController {
    @Autowired
    @Qualifier(value = "productEntityManager")
    private EntityManager em;
    @Autowired
    ApplyService applyService;
    @Autowired
    UserStatusService statusService;

    @RequestMapping(value = "/get",method = RequestMethod.POST)
    //@JsonView(View.ApplyForView.class)
    public @ResponseBody
    JsonResponse getApplyList(@RequestBody ApplyConditions applyConditions) throws Exception {
//        long start = 0;
//        long end = UtilServiceImpl.date2Long(new Date());
//        String format = "yyyy-MM-dd";
//        if(applySearchCondition.getTime()!=null)
//        {   String[] time= applySearchCondition.getTime();
//            start=UtilServiceImpl.string2Long(time[0],format);
//            end=UtilServiceImpl.string2Long(time[1],format)+ 86400000;
//        }

        long userId=statusService.getCurrUserId(SecurityUtils.getSubject().getSession());

        applyConditions.setUserId(userId);
//        try {
//            Enumeration<String> queryNames=request.getParameterNames();
//            while(queryNames.hasMoreElements())
//            {   String query=queryNames.nextElement();
//                Integer.parseInt(request.getParameter(query));
//            }
//
//            page = Integer.parseInt(request.getParameter("page"));
//            size = Integer.parseInt(request.getParameter("size"));
//            device_id = Integer.parseInt(request.getParameter("deviceId"));
//            JSONArray json = new JSONArray(request.getParameter("time"));
//            orderby=Integer.parseInt(request.getParameter("OrderBy"));
//            start = UtilServiceImpl.string2Long(json.getString(0), format);
//            //end要加一天的时间
//            end = UtilServiceImpl.string2Long(json.getString(1), format) + 86400000;
//        }catch (Exception e)
//        {//do nothing maybe the format is not suitable
//            e.printStackTrace();
//        }
        ApplySearchCondition searchCondition=new ApplySearchCondition(applyConditions);
        Sort sort = null;
        switch (applyConditions.getOrderBy()){
            case 1:
                sort = new Sort(Sort.Direction.ASC, "id");
                break;
            case 2:
                sort=new Sort(Sort.Direction.ASC, "createAt");
                break;
            case 3:
                sort=new Sort(Sort.Direction.ASC, "updateAt");
                break;
        }


        Pageable pageable = new PageRequest(applyConditions.getPage(), applyConditions.getSize(), sort);
        CustomePage<ApplyResponse> applyInfos = searchCondition.result(searchCondition.searchByConditions(em),pageable);
//        applyInfos.map(new Converter<ApplyInfo,ApplyResponse>(){
//            @Override
//            public ApplyResponse convert(ApplyInfo applyInfo) {
//                return new ApplyResponse(applyInfo);
//            }
//        });
        return new JsonResponse(200,null,applyInfos);

    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public @ResponseBody
    JsonResponse     getApply(@RequestParam("applyId") long id) {
//        JSONObject object=new JSONObject( applyService.findByApplyID(id,SecurityUtils.getSubject()
//                .getSession()));
//        System.out.println(object.toString());
        //return applyService.findByApplyID(id,SecurityUtils.getSubject().getSession());

        return new JsonResponse(200, null, new ApplyResponse(applyService.findByApplyID(id,SecurityUtils.getSubject().getSession())));

    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse createApply(@RequestBody ApplyInfo applyInfo) throws Exception {

        applyInfo.setCreateTime(UtilServiceImpl.date2Long(new Date()));
        //System.out.println(new JSONObject(applyInfo.getForm1()).toString());
        applyInfo.setStatus(new ApplyStatus());
        applyService.createApply(applyInfo,statusService.getCurrUserId(SecurityUtils.getSubject().getSession()));
        return new JsonResponse();


    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public @ResponseBody
    JsonResponse delApply(@RequestParam("applyId") long id) throws RuntimeException{
        applyService.delApply(id,SecurityUtils.getSubject().getSession());
        return new JsonResponse();

    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse updateApply(@RequestBody ApplyInfo applyInfo) throws RuntimeException{

        applyService.saveApply(applyInfo,SecurityUtils.getSubject().getSession());
        return new JsonResponse();

    }
    @RequestMapping(value = "/confirm",method = RequestMethod.GET)
    public @ResponseBody JsonResponse confirmApply(@RequestParam("applyId") long id)throws Exception{
        applyService.confirmApply(id,SecurityUtils.getSubject().getSession());
        return new JsonResponse();

    }

}
