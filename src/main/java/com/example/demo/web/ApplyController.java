package com.example.demo.web;

import com.example.demo.entity.dataModel.ApplyInfo;
import com.example.demo.entity.dataModel.ApplyStatus;
import com.example.demo.enums.JsonResponse;
import com.example.demo.service.ApplyService;
import com.example.demo.service.staticfunction.UtilServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by yang on 2017/7/27.
 */
@Controller
@RequestMapping("/apply")

public class ApplyController {

    @Autowired
    ApplyService applyService;

    @RequestMapping(value = "/get",method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse getApplyList(HttpServletRequest request) throws Exception {
        int page = 0, size = 3, device_id = 0;
        long start = 0;
        int orderby=1;
        long end = UtilServiceImpl.date2Long(new Date());
        String format = "yyyy-MM-dd";
        try {
            page = Integer.parseInt(request.getParameter("page"));
            size = Integer.parseInt(request.getParameter("size"));
            device_id = Integer.parseInt(request.getParameter("device_id"));
            JSONArray json = new JSONArray(request.getParameter("time"));
            orderby=Integer.parseInt(request.getParameter("OrderBy"));
            start = UtilServiceImpl.string2Long(json.getString(0), format);
            //end要加一天的时间
            end = UtilServiceImpl.string2Long(json.getString(1), format) + 86400000;
        }catch (Exception e)
        {//do nothing maybe the format is not suitable
        }
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        switch (orderby){
            case 1:
                break;
            case 2:
                sort=new Sort(Sort.Direction.ASC, "createAt");
                break;
            case 3:
                sort=new Sort(Sort.Direction.ASC, "updateAt");
                break;
        }


        Pageable pageable = new PageRequest(page, size, sort);
        Page<ApplyInfo> applyInfos = applyService.findstream(device_id, start, end, pageable);
        return new JsonResponse(true,null,applyInfos);

    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public @ResponseBody
    JsonResponse getApply(@RequestParam("applyId") long id) {

        return new JsonResponse(true, null, applyService.findByApplyID(id));

    }


    @RequestMapping(value = "/create", method = RequestMethod.PUT)
    public @ResponseBody
    JsonResponse createApply(@RequestBody ApplyInfo applyInfo) throws Exception {
//        try {
        applyInfo.setCreateTime(UtilServiceImpl.string2Long("2016-10-12", "yyyy-MM-dd") + 1000000);
        applyInfo.setApplyStatus(new ApplyStatus());
        applyService.createApply(applyInfo);
        return new JsonResponse(true, null, null);

//        } catch (ParseException e) {
//            System.out.println("无法解析");
//            return false;
//        }

    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public @ResponseBody
    JsonResponse delApply(@RequestParam("applyId") long id) throws RuntimeException{
        applyService.delApply(applyService.findByApplyID(id));
        return new JsonResponse(true, null, null);

    }
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public @ResponseBody
    JsonResponse updateApply(@RequestParam("applyId") long id) throws RuntimeException{
        applyService.saveApply(applyService.findByApplyID(id), SecurityUtils.getSubject());
        return new JsonResponse(true, null, null);

    }

}
