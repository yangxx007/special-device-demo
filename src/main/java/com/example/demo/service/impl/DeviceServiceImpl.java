package com.example.demo.service.impl;

import com.example.demo.connector.conditions.DeviceConditions;
import com.example.demo.connector.responser.ApplyResponse;
import com.example.demo.dao.device.DeviceDao;
import com.example.demo.entity.data.ApplyInfo;
import com.example.demo.entity.device.DeviceInfo;
import com.example.demo.enums.CustomePage;
import com.example.demo.enums.DeviceStatesEnum;
import com.example.demo.enums.RoleTypeEnum;
import com.example.demo.service.Apply2DeviceService;
import com.example.demo.service.DeviceService;
import com.example.demo.service.staticfunction.UtilServiceImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author yang
 * @create_at 17-10-26
 **/
@Service
public class DeviceServiceImpl implements DeviceService,Apply2DeviceService {
    @Autowired
    private DeviceDao deviceDao;
    private DeviceInfo device;
    private ApplyInfo applyInfo;


    @Override
    public DeviceInfo getDeviceById(long id) {
        return deviceDao.findByOwnerId(id);
    }

    @Override
    public DeviceInfo save(DeviceInfo deviceInfo) {
        return deviceDao.save(deviceInfo);
    }


    @Override
    public DeviceInfo apply2Device(ApplyInfo applyInfo,boolean pass) {
        this.applyInfo=applyInfo;
        if(applyInfo.getDeviceId()!=0){
        this.device=getDeviceById(applyInfo.getDeviceId());}
        if(pass) {
            switch (applyInfo.getApplyType()) {
                case 停用申请:
                    stopDevice();
                    break;
                case 变更申请:
                    changeDevice();
                    break;
                case 报废申请:
                    dropDevice();
                    break;
                case 首次申请:
                    createDevice();
                    break;
                case 停用后启用申请:
                    reuseDevice();
                    break;
                default:
                    break;
            }

        }
        device.endprocessing();
        device.addLogs(new JSONObject(new ApplyResponse(applyInfo)).toString());
        return deviceDao.save(device);
    }

    private void dropDevice() {
        device.scrapped();

    }
    private void reuseDevice() {
        device.enabled();

    }
    private void createDevice() {
        DeviceInfo device=new DeviceInfo();
        device.setAgencyId(applyInfo.getAcceptorAgencyId());
        device.setCreateAt(UtilServiceImpl.date2Long(new Date()));
        device.setOwnerId(applyInfo.getOwnerId());
        device.setDeviceCategory(applyInfo.getDeviceCategory());
        device.setDeviceClass(applyInfo.getDeviceClass());
        device.setDeviceCode(applyInfo.getDeviceCode());
        device.setDeviceKind(applyInfo.getDeviceKind());

    }

    private void changeDevice() {
        DeviceInfo device=deviceDao.findById(applyInfo.getDeviceId());
        device.changed();

    }

    private void stopDevice() {
        DeviceInfo device=deviceDao.findById(applyInfo.getDeviceId());
        device.disabled();

    }
}
