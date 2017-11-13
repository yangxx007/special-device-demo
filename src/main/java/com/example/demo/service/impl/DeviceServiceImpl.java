package com.example.demo.service.impl;

import com.example.demo.dao.device.DeviceDao;
import com.example.demo.dao.device.UseRegistCertificateDao;
import com.example.demo.dao.map.DistrictDao;
import com.example.demo.dao.map.OrganizationDao;
import com.example.demo.entity.data.ApplyInfo;
import com.example.demo.entity.data.District;
import com.example.demo.entity.data.Organization;
import com.example.demo.entity.device.DeviceInfo;
import com.example.demo.entity.form.Form;
import com.example.demo.entity.form.SubForm;
import com.example.demo.enums.ApplyTypeEnum;
import com.example.demo.enums.DeviceTypeEnum;
import com.example.demo.enums.FormTypeEnum;
import com.example.demo.service.*;
import com.example.demo.service.exception.CustomException;
import com.example.demo.service.utils.RegistCodeGenerater;
import com.example.demo.service.utils.UtilServiceImpl;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yang
 * @create_at 17-10-26
 **/
@Service
public class DeviceServiceImpl  implements DeviceService,Apply2DeviceService {
    @Autowired
    private DeviceDao deviceDao;
    private DeviceInfo device;
    private List<DeviceInfo> devices;
    private ApplyInfo applyInfo;
    @Autowired
    private OrganizationDao organizationDao;
    @Autowired
    private ValidateService validateService;
    @Autowired
    private RegisterCertificateService certificateService;
    @Autowired
    private UserStatusService userStatusService;

    @Override
    public DeviceInfo getDeviceById(long id,Session session) {
        DeviceInfo deviceInfo=deviceDao.findById(id);
        validateService.isPermission(session,deviceInfo);
        return deviceInfo;
    }

    @Override
    public DeviceInfo save(DeviceInfo deviceInfo) {
        return deviceDao.save(deviceInfo);
    }

    @Override
    public List<DeviceInfo> getOwnerDevices(Session session) {
        return deviceDao.findAllByOwnerId(userStatusService.getCurrUserId(session));
    }

    @Override
    public long deviceTotalNum(DeviceTypeEnum deviceTypeEnum) {
        return deviceDao.countAllByDeviceType(deviceTypeEnum);
    }

    @Override
    public void device2Apply(long deviceId, ApplyInfo apply) {
        DeviceInfo deviceInfo=deviceDao.findById(deviceId);
        apply.setEqCode(deviceInfo.getEqCode());
        apply.setDeviceCategory(deviceInfo.getDeviceCategory());
        apply.setDeviceClass(deviceInfo.getDeviceClass());
        apply.setDeviceKind(deviceInfo.getDeviceKind());
        apply.setAcceptorAgencyId(deviceInfo.getAcceptorAgencyId());
        apply.setAcceptorAgencyName(deviceInfo.getAcceptorAgencyName());
        apply.setUseComName(deviceInfo.getUseComName());
        apply.setDeviceType(deviceInfo.getDeviceType());
    }
    @Override
    public DeviceInfo apply2Device(ApplyInfo applyInfo,boolean pass,Session session) throws Exception{
        this.applyInfo=applyInfo;
        devices=new ArrayList<>();
        if(applyInfo.getDeviceList()!=null&&applyInfo.getDeviceList().length!=0)
        {
            for(long id:applyInfo.getDeviceList()){
                System.out.println(id);
                devices.add(getDeviceById(id,session));
            }
        }else{
            if(applyInfo.getDeviceId()!=0){
                this.device=getDeviceById(applyInfo.getDeviceId(),session);
                devices.add(device);}
            else{
                this.device=new DeviceInfo();
                devices.add(device);
            }
        }
        for(DeviceInfo subdevice:devices){
            device=subdevice;
            if(pass) {
            switch (applyInfo.getApplyType()) {
                case 停用申请:
                    stopDevice();
                    break;
                case 首次申请:
                    createDevice(applyInfo);
                    break;
                case 变更申请:
                    changeDevice();
                    break;
                case 报废申请:
                    dropDevice();
                    break;
                case 停用后启用申请:
                    reuseDevice();
                    break;
                default:
                    break;
                }
            }
        }

        return device;
    }

    private void dropDevice() {
        device.scrapped();
        device.addLogs(applyInfo);
        device.endprocessing();
        deviceDao.save(device);

    }
    private void reuseDevice() {
        device.enabled();
        device.addLogs(applyInfo);
        device.endprocessing();
        deviceDao.save(device);

    }
    @Override
    public void createDevice(ApplyInfo applyInfo)throws Exception{
        List<Form> forms=applyInfo.getFormList();
        for(Form form:forms){
        switch (form.getFormType()){
            case 特种设备使用登记表二:
                for(SubForm form1:form.getSubList()){
                    this.device.setProductCode(form1.getProductCode());
                    /**other properties can be done here
                     * **/
                    createDevice();
                }
                break;
            case 特种设备使用登记表一:
                createDevice();
                break;
            default:
                device=null;
                break;
        }
        }

    }
    private void createDevice() throws Exception{
        DeviceInfo device=new DeviceInfo();
        device.setAgencyId(applyInfo.getAcceptorAgencyId());
        device.setCreateTime(UtilServiceImpl.date2Long(new Date()));
        device.setOwnerId(applyInfo.getOwnerId());
        device.setDeviceType(applyInfo.getDeviceType());
        device.setDeviceCategory(applyInfo.getDeviceCategory());
        device.setDeviceClass(applyInfo.getDeviceClass());
        device.setEqCode(applyInfo.getEqCode());
        device.setDeviceKind(applyInfo.getDeviceKind());
        device.addLogs(applyInfo);
        certificateService.createCertificate(device,organizationDao.findOrganizationById((int)applyInfo.getAcceptorAgencyId()),applyInfo.getDeviceCode(),applyInfo.getDeviceType());
        this.device=device;
        deviceDao.save(this.device);

    }

    private void changeDevice() {
        device.changed();
        device.addLogs(applyInfo);
        device.endprocessing();
        deviceDao.save(device);

    }

    private void stopDevice() {
        device.disabled();
        device.addLogs(applyInfo);
        device.endprocessing();
        deviceDao.save(device);

    }
}
