package com.example.demo.web;

import com.example.demo.connector.conditions.ApplyConditions;
import com.example.demo.connector.conditions.DeviceConditions;
import com.example.demo.connector.responser.ApplyResponse;
import com.example.demo.connector.responser.DeviceResponse;
import com.example.demo.dao.apply.ApplySearchCondition;
import com.example.demo.dao.device.DeviceSearchCondition;
import com.example.demo.entity.device.DeviceInfo;
import com.example.demo.enums.CustomePage;
import com.example.demo.enums.JsonResponse;
import com.example.demo.service.DeviceService;
import com.example.demo.service.UserStatusService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author yang
 * @create_at 17-10-24
 **/
@Controller
@RequestMapping("/device")
public class DeviceController extends BaseController{
    @Autowired
    @Qualifier(value = "productEntityManager")
    private EntityManager em;
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private UserStatusService statusService;

    @RequestMapping(value = "/get",method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse getDeviceLists(@RequestBody DeviceConditions conditions)throws Exception{
        long id=statusService.getCurrUserId(getSession());
        conditions.setUserId(id);
        DeviceSearchCondition searchCondition=new DeviceSearchCondition(conditions);
        Pageable pageable = new PageRequest(conditions.getPage(), conditions.getSize(), conditions.getSort());
        CustomePage<DeviceResponse> devices = searchCondition.result(searchCondition.searchByConditions(em),pageable);
        return new JsonResponse(200,null,devices);

    }
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public @ResponseBody
    JsonResponse getDeviceLists(@RequestParam(name = "deviceId")long deviceId){

        return new JsonResponse(200,null,deviceService.getDeviceById(deviceId,getSession()));
    }
}
