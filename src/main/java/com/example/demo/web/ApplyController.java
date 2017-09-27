package com.example.demo.web;

import com.example.demo.entity.dataModel.ApplyInfo;
import com.example.demo.entity.dataModel.ApplyStatus;
import com.example.demo.enums.JsonResponse;
import com.example.demo.enums.MyPage;
import com.example.demo.service.impl.SearchCondition;
import com.example.demo.service.ApplyService;
import com.example.demo.service.UserStatusService;
import com.example.demo.service.staticfunction.UtilServiceImpl;
import com.example.demo.service.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.apache.shiro.SecurityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by yang on 2017/7/27.
 */
@Controller
@RequestMapping("/apply")

public class ApplyController {

    @Autowired
    ApplyService applyService;
    @Autowired
    UserStatusService statusService;

    @RequestMapping(value = "/get",method = RequestMethod.POST)
    @JsonView(View.ApplyForView.class)
    public @ResponseBody
    JsonResponse getApplyList(@RequestBody SearchCondition searchCondition) throws Exception {
        long start = 0;
        long end = UtilServiceImpl.date2Long(new Date());
        String format = "yyyy-MM-dd";
        if(searchCondition.getTime()!=null)
        {   String[] time=searchCondition.getTime();
            start=UtilServiceImpl.string2Long(time[0],format);
            end=UtilServiceImpl.string2Long(time[1],format)+ 86400000;
        }

        long userId=statusService.getCurrUserId(SecurityUtils.getSubject().getSession());


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
        Sort sort = null;
        switch (searchCondition.getOderBy()){
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

        Pageable pageable = new PageRequest(searchCondition.getPage(), searchCondition.getSize(), sort);
        MyPage<ApplyInfo> applyInfos = new MyPage<>(applyService.searchForUser(userId,searchCondition.getDeviceTypeId(), start, end,
                pageable));
        return new JsonResponse(true,null,applyInfos);

    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public @ResponseBody
    JsonResponse     getApply(@RequestParam("applyId") long id) {
        JSONObject object=new JSONObject( applyService.findByApplyID(id,SecurityUtils.getSubject()
                .getSession()));
        System.out.println(object.toString());
        //return applyService.findByApplyID(id,SecurityUtils.getSubject().getSession());
        return new JsonResponse(true, null, applyService.findByApplyID(id,SecurityUtils.getSubject().getSession()));

    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse createApply(@RequestBody ApplyInfo applyInfo) throws Exception {

        applyInfo.setCreateTime(UtilServiceImpl.date2Long(new Date()));
        //System.out.println(new JSONObject(applyInfo.getForm1()).toString());
        applyInfo.setApplyStatus(new ApplyStatus());
        applyService.createApply(applyInfo,statusService.getCurrUserId(SecurityUtils.getSubject().getSession()));
        return new JsonResponse(true, null, null);


    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public
    JsonResponse delApply(@RequestParam("applyId") long id) throws RuntimeException{
        applyService.delApply(id,SecurityUtils.getSubject().getSession());
        return new JsonResponse(true, null, null);

    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse updateApply(@RequestBody ApplyInfo applyInfo) throws RuntimeException{

        applyService.saveApply(applyInfo,SecurityUtils.getSubject().getSession());
        return new JsonResponse(true, null, null);

    }
    @RequestMapping(value = "/confirm",method = RequestMethod.GET)
    public @ResponseBody JsonResponse confirmApply(@RequestParam("applyId") long id)throws Exception{
        applyService.confirmApply(id,SecurityUtils.getSubject().getSession());
        return new JsonResponse(true, null, null);

    }

}
