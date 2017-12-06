package com.example.demo.web;

import com.example.demo.connector.conditions.ApplyConditions;
import com.example.demo.connector.conditions.DeviceConditions;
import com.example.demo.connector.responser.ApplyResponse;
import com.example.demo.connector.responser.DeviceResponse;
import com.example.demo.dao.apply.ApplySearchCondition;
import com.example.demo.dao.device.DeviceSearchCondition;
import com.example.demo.dao.device.MultiDeviceDao;
import com.example.demo.entity.device.DeviceInfo;
import com.example.demo.entity.form.SubForm;
import com.example.demo.enums.CustomePage;
import com.example.demo.enums.JsonResponse;
import com.example.demo.service.DeviceService;
import com.example.demo.service.UserStatusService;
import com.example.demo.service.exception.CustomException;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.json.JSONObject;
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
@RequiresPermissions("user:normal")
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
        if(!conditions.isProcessing()){
            conditions.setViewAll(false);
        }
        DeviceSearchCondition searchCondition=new DeviceSearchCondition(conditions);
        CustomePage<DeviceResponse> devices=null;
        if(conditions.getSize()==0){
             devices= searchCondition.result(searchCondition.searchByConditions(em));
        }else{
        Pageable pageable = new PageRequest(conditions.getPage(), conditions.getSize(), conditions.getSort());
            devices = searchCondition.result(searchCondition.searchByConditions(em),pageable);}
        return new JsonResponse(200,null,devices);

    }
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public @ResponseBody
    JsonResponse getDevice(@RequestParam(name = "deviceId")long deviceId){

        return new JsonResponse(200,null,deviceService.getDeviceById(deviceId,getSession()));
    }
    @Autowired
    private MultiDeviceDao deviceDao;
    @RequestMapping(value = "/pipe",method = RequestMethod.GET)
    public @ResponseBody
    JsonResponse getPipe(@RequestParam("eqCode")String eqcode){
        return new JsonResponse(200,null,deviceService.getPipeByEqCode(getSession(),eqcode));
    }
    @RequestMapping(value = "/cylinder",method = RequestMethod.GET)
    public @ResponseBody
    JsonResponse getCylinder(@RequestParam(name="eqCode")String eqcode){
        return new JsonResponse(200,null,deviceService.getCylinderByEqCode(getSession(),eqcode));
    }
    @RequestMapping(value = "/pipe",method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse updatePipe(@RequestBody SubForm pipe){
        if(deviceService.getPipeByEqCode(getSession(),pipe.getEqCode())==null){
            throw new CustomException("you do not have permission to do the operation");
        }
        pipe.setOwnerId(statusService.getCurrUserId(getSession()));
        return new JsonResponse(200,null,deviceService.updateSubForm(pipe));
    }
    @RequestMapping(value = "/cylinder",method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse updateCylinder(@RequestBody SubForm cylinder){
        SubForm cylinder2=deviceService.getCylinderByEqCode(getSession(),cylinder.getEqCode());
        if(cylinder2==null){
            throw new CustomException("you do not have permission to do the operation");
        }
        cylinder.setOwnerId(cylinder2.getOwnerId());
        cylinder.setId(cylinder2.getId());
        return new JsonResponse(200,null,deviceService.updateSubForm(cylinder));
    }
}
