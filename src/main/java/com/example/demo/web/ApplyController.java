package com.example.demo.web;

import com.example.demo.entity.dataModel.ApplyInfo;
import com.example.demo.entity.dataModel.ApplyStatus;
import com.example.demo.enums.JsonResponse;
import com.example.demo.service.ApplyService;
import com.example.demo.service.staticfunction.UtilServiceImpl;
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
    @RequestMapping("/applylist")
    public @ResponseBody
    JsonResponse getApplyList(HttpServletRequest request) {
        int page=0,size=1,device_id=0;
        long start = 0;
        long end = UtilServiceImpl.date2Long(new Date());
        String format = "yyyy-MM-dd";
        JsonResponse jsonResponse=new JsonResponse();
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
            jsonResponse.setStatus(false);
            jsonResponse.setMsg(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
            jsonResponse.setStatus(false);
            jsonResponse.setMsg(e.getMessage());
        }
//        System.out.println(start);
//        System.out.println(end);
//        return applyService.findApplyInfosForUser(1,
//                device_id, start, end, pageable);
        jsonResponse.setStatus(true);
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
        jsonResponse.setData(applyInfos);
        return jsonResponse;
//        return applyService.findApplyInfosForUser(userStatusService.getCurrUserId(SecurityUtils.getSubject()),
//                device_id,start,end);
    }
    @RequestMapping(value = "/apply", method = RequestMethod.GET)
    public @ResponseBody
    ApplyInfo getApply(@RequestParam("apply_id") long id) {
        return applyService.findByApplyID(id);
    }


    @RequestMapping(value = "/applytest", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody
    List<ApplyInfo> getApply2() {
//        List<ApplyInfo> applyInfos=null;
//
//       try{
//            applyInfos=applyService.findtest(applyService.findstream(1)).collect(Collectors.toList());
//           //applyInfoStream.forEach(applyInfo -> applyInfos.add(applyInfo));
//       }
//       catch (Exception e)
//       {
//           System.out.println(e.getLocalizedMessage());
//       }
        return null;
    }

    @RequestMapping(value = "/apply", method = RequestMethod.PUT)
    public @ResponseBody
    boolean createApply(@RequestBody ApplyInfo applyInfo) {
        try {
            applyInfo.setCreateTime(UtilServiceImpl.string2Long("2016-10-12", "yyyy-MM-dd")+1000000);
            applyInfo.setApplyStatus(new ApplyStatus());
            applyService.createApply(applyInfo);
        } catch (ParseException e) {
            System.out.println("无法解析");
            return false;
        }
        return true;
    }
    @RequestMapping(value = "/apply",method = RequestMethod.DELETE)
    public void delApply(@RequestParam("applyId")long id)
    {
        applyService.delApply(applyService.findByApplyID(id));

    }
}
