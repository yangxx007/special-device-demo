package com.example.demo.service.impl;

import com.example.demo.dao.device.DeviceDao;
import com.example.demo.dao.device.MultiDeviceDao;
import com.example.demo.dao.device.PipeOrCylinderDao;
import com.example.demo.dao.map.OrganizationDao;
import com.example.demo.entity.data.ApplyInfo;
import com.example.demo.entity.device.CylindersInfo;
import com.example.demo.entity.device.DeviceInfo;
import com.example.demo.entity.device.PipesInfo;
import com.example.demo.entity.form.Form;
import com.example.demo.entity.form.SubForm;
import com.example.demo.entity.user.UserInfo;
import com.example.demo.enums.ApplyTypeEnum;
import com.example.demo.enums.DeviceTypeEnum;
import com.example.demo.enums.FormTypeEnum;
import com.example.demo.service.*;
import com.example.demo.service.exception.CustomException;
import com.example.demo.service.utils.UtilServiceImpl;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    private MultiDeviceDao multiDeviceDao;
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
        apply.setDeviceCode(deviceInfo.getDeviceCode());
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
                devices.add(getDeviceById(id,session));
            }
        }else{
            //creating a new device only match the first apply
            if(applyInfo.getApplyType()== ApplyTypeEnum.首次申请){
                this.device=new DeviceInfo();
                devices.add(device);
            } else if(applyInfo.getDeviceId()!=0){
                this.device=getDeviceById(applyInfo.getDeviceId(),session);
                devices.add(device);}
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
                case 单位变更申请:
                    changeCom();
                    break;
                case 跨区域变更申请:
                    changeAgency();
                    break;
                default:
                    break;
                }
            }
        }

        return device;
    }

    //change device's owner company

    private void changeCom() throws Exception{

        if(applyInfo.getFormList().get(0).getFormType()== FormTypeEnum.特种设备使用登记证变更证明){
            device.updating();
            device.addLogs(applyInfo);
            deviceDao.save(device);
        }else {
            if(applyInfo.getEqCode()!=null){
                this.device=deviceDao.findByEqCode(applyInfo.getEqCode());
                devices.add(device);
            }else {
                throw new CustomException("eqCode is not founded");
            }
            changeDevice();
        }

    }

    //change the register agency

    private void changeAgency()throws Exception{
        if(applyInfo.getFormList().get(0).getFormType()== FormTypeEnum.特种设备使用登记证变更证明){
            device.updating();
            device.addLogs(applyInfo);
            device.endprocessing();
            deviceDao.save(device);
        }else {
            changeDevice();
        }
    }

    //drop device method

    private void dropDevice() {
        device.scrapped();
        device.addLogs(applyInfo);
        device.endprocessing();
        deviceDao.save(device);

    }
    //reuse device method while device's status is disable

    private void reuseDevice() {
        device.enabled();
        device.addLogs(applyInfo);
        device.endprocessing();
        deviceDao.save(device);

    }
    //create n devices by an apply or create 1 device by an apply
    @Override
    public void createDevice(ApplyInfo applyInfo)throws Exception{
        List<Form> forms=applyInfo.getFormList();
        for(Form form:forms){
        switch (form.getFormType()){
            case 特种设备使用登记表二:
                for(SubForm form1:form.getSubList()){
                    this.device.setProductCode(form1.getProductCode());
                    /**other properties can be write down here
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

    @Override
    public SubForm getPipeByEqCode(Session session,String pipeCode) {

        return multiDeviceDao.findByOwnerIdAndEqCodeAndDeviceType(userStatusService.getCurrUserId(session),pipeCode,DeviceTypeEnum.工业管道);
    }

    @Override
    public List<SubForm> getPipeListByOwner(Session session) {
        return multiDeviceDao.findByOwnerIdAndDeviceType(userStatusService.getCurrUserId(session),DeviceTypeEnum.工业管道);
    }

    @Override
    public SubForm getCylinderByEqCode(Session session,String code) {
        return multiDeviceDao.findByOwnerIdAndEqCodeAndDeviceType(userStatusService.getCurrUserId(session),code,DeviceTypeEnum.普通气瓶);
    }

    @Override
    public List<SubForm> getCylinderByEqCode(Session session) {
        return multiDeviceDao.findByOwnerIdAndDeviceType(userStatusService.getCurrUserId(session),DeviceTypeEnum.普通气瓶);
    }

    @Override
    public Object updateSubForm(SubForm cylinder) {
        return multiDeviceDao.save(cylinder);
    }


    private void createDevice() throws Exception{
        DeviceInfo deviceInfo=apply2Device();
        certificateService.createCertificate(deviceInfo,organizationDao.findOrganizationById((int)applyInfo.getAcceptorAgencyId()),applyInfo.getDeviceCode(),applyInfo.getDeviceType());
        this.device=deviceInfo;
        deviceDao.save(this.device);

    }

    //create a device through an apply

    private DeviceInfo apply2Device(){
        DeviceInfo device=new DeviceInfo();
        device.setAgencyId(applyInfo.getAcceptorAgencyId());
        device.setCreateTime(UtilServiceImpl.date2Long(new Date()));
        device.setComCode(applyInfo.getComCode());
        device.setOwnerId(applyInfo.getOwnerId());
        device.setAcceptorAgencyName(applyInfo.getAcceptorAgencyName());
        device.setOwnerComName(applyInfo.getUseComName());
        device.setDeviceType(applyInfo.getDeviceType());
        device.setDeviceCategory(applyInfo.getDeviceCategory());
        device.setDeviceClass(applyInfo.getDeviceClass());
        device.setDeviceCode(applyInfo.getDeviceCode());
        device.setRegistPerson(applyInfo.getSafeAdministrator());
        device.setEqCode(applyInfo.getEqCode());
        device.setEqUseAddr(applyInfo.getEqUseAddr());
        device.setComTablePerson(applyInfo.getComTablePerson());
        device.setDeviceKind(applyInfo.getDeviceKind());
        device.setRegistPerson(applyInfo.getStatus().getApproverName());
        device.addLogs(applyInfo);
        device.setDeviceSerialNum(deviceDao.countAllByDeviceType(applyInfo.getDeviceType())+1);
        return device;
    }

    //change device

    private void changeDevice()throws Exception {
        DeviceInfo deviceInfo=apply2Device();
        deviceInfo.setId(device.getId());
        deviceInfo.setDeviceCode(device.getDeviceCode());
        deviceInfo.setDeviceType(device.getDeviceType());
        deviceInfo.setCreateTime(device.getCreateTime());
        deviceInfo.setLogs(device.getLogs());
        deviceInfo.setNoUseDate(device.getNoUseDate());
        deviceInfo.setNoUseEndDate(device.getNoUseEndDate());
        deviceInfo.setDisableDate(device.getDisableDate());
        deviceInfo.setDeviceSerialNum(device.getDeviceSerialNum());
        deviceInfo.addLogs(applyInfo);
        deviceInfo.endprocessing();
        certificateService.createCertificate(deviceInfo,organizationDao.findOrganizationById((int)applyInfo.getAcceptorAgencyId()),applyInfo.getDeviceCode(),applyInfo.getDeviceType());
        deviceDao.save(deviceInfo);
    }

    private void stopDevice() {
        device.disabled();
        device.addLogs(applyInfo);
        device.endprocessing();
        deviceDao.save(device);

    }
}
