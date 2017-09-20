package com.example.demo.web;

import com.example.demo.entity.dataModel.ApplyInfo;
import com.example.demo.service.ApplyService;
import com.example.demo.service.staticfunction.UtilServiceImpl;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping("/applylist")
    public @ResponseBody
    Page<ApplyInfo> getApplyList(HttpServletRequest request) {
        int page=0,size=1,device_id=0;
        long start = 0;
        long end = UtilServiceImpl.date2Long(new Date());
        String format = "yyyy-MM-dd";

        try {
            page=Integer.parseInt(request.getParameter("page"));
            size=Integer.parseInt(request.getParameter("size"));
            device_id=Integer.parseInt(request.getParameter("device_id"));
            JSONArray json= new JSONArray(request.getParameter("time"));
            start = UtilServiceImpl.string2Long(json.getString(0), format);
            //end要加一天的时间
            end = UtilServiceImpl.string2Long(json.getString(1), format)+86400000;

        } catch (ParseException e) {
            System.out.println("筛选条件输入错误");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        System.out.println(start);
//        System.out.println(end);
//        return applyService.findApplyInfosForUser(1,
//                device_id, start, end, pageable);
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<ApplyInfo> applyInfos=applyService.findstream(device_id,start,end,pageable);
//        System.out.println(new JSONObject(applyInfos).get("sort").toString());
//        List<ApplyInfo> applyInfoList=(List<ApplyInfo>) new JSONObject(applyInfos).get("content");
//        JSONObject applyObject=new JSONObject();
//        int i=0;
//        for(ApplyInfo apply: applyInfoList) {
//            System.out.println(apply.getId());
//            ApplyStatus applyStatus=applyService.findApplyStatusByApplyId(apply.getId());
//            applyObject.append(i+"",(new JSONObject(apply)).toString()+(new JSONObject(applyStatus)).toString());
//            i++;
//        }
//        return applyInfos;
        return applyInfos;
//        return applyService.findApplyInfosForUser(userStatusService.getCurrUserId(SecurityUtils.getSubject()),
//                device_id,start,end);
    }

}
