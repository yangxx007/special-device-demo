package com.example.demo.entity.device;

import com.example.demo.entity.data.ApplyInfo;
import com.example.demo.enums.ApplyTypeEnum;
import com.example.demo.enums.DeviceStatesEnum;
import com.example.demo.enums.DeviceTypeEnum;
import com.example.demo.service.Validatable;
import com.example.demo.service.exception.CustomException;
import com.example.demo.service.utils.UtilServiceImpl;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * @author yang
 * @create_at 17-10-24
 **/
@Entity
public class DeviceInfo implements Serializable,Validatable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String eqCode;
    private String comCode;
    private DeviceTypeEnum deviceType;
    private int     deviceTypeId;
    private String deviceCategory;
    private String deviceClass;
    private String deviceKind;
    private String noUseDate;
    private String noUseEndDate;
    private String disableDate;
    private String comTablePerson;
    private String acceptorAgencyName;
    private String registPerson;
    private String productCode;
    private String useComName;
    private String eqUseAddr;
    @Column(unique = true)
    private String registCode;
    private DeviceStatesEnum deviceStates=DeviceStatesEnum.在用;
    private long ownerId;
    private String ownerComName;
    private long agencyId;
    private long createTime;
    private boolean processing;
    private long processedApplyId;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<DeviceLogs> logs;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDeviceCategory() {
        return deviceCategory;
    }

    public void setDeviceCategory(String deviceCategory) {
        this.deviceCategory = deviceCategory;
    }

    public String getDeviceClass() {
        return deviceClass;
    }

    public void setDeviceClass(String deviceClass) {
        this.deviceClass = deviceClass;
    }

    public String getDeviceKind() {
        return deviceKind;
    }

    public void setDeviceKind(String deviceKind) {
        this.deviceKind = deviceKind;
    }

    public DeviceStatesEnum getDeviceStates() {
        return deviceStates;
    }

    public void setDeviceStates(DeviceStatesEnum deviceStates) {
        this.deviceStates = deviceStates;
    }

    @Override
    public long getAcceptorAgencyId() {
        return agencyId;
    }

    @Override
    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public void setAgencyId(long agencyId) {
        this.agencyId = agencyId;
    }

    public void scrapped(){
        if(deviceStates==DeviceStatesEnum.在用||deviceStates==DeviceStatesEnum.停用) {
            this.deviceStates = DeviceStatesEnum.报废;
        }else{
            throw new CustomException("can not change device states or already changed");
        }
    }
    public void disabled(){
        if (deviceStates==DeviceStatesEnum.在用){
            this.deviceStates=DeviceStatesEnum.停用;
        }
//        else{
//            throw new CustomException("can not change device states or already changed");
//        }
    }
    public void enabled(){
        if(this.deviceStates==DeviceStatesEnum.停用){
            this.deviceStates=DeviceStatesEnum.在用;
        }
//        else{
//            throw new CustomException("can not change device states or already changed");
//        }
    }
    public void endprocessing(){
        if(processing==true) {
            this.createTime = UtilServiceImpl.date2Long(new Date());
            this.processing = false;
        }
//        else{
//            throw new CustomException("can not change device states or already changed");
//        }
    }
    public void processing(long applyId){
        if(processing==false){
        this.processing=true;
        this.processedApplyId=applyId;
        }
//        else{
//            throw new CustomException("can not change device states or already changed");
//        }
    }
    public void addLogs(ApplyInfo applyInfo){
        DeviceLogs logs=new DeviceLogs();
        logs.setUpdateTime(applyInfo.getCreateTime()+"");
        logs.setApplyId(applyInfo.getId());
        logs.setApplyType(applyInfo.getApplyType());
        if(this.logs==null){
            this.logs=new ArrayList<>();
        }
        this.logs.add(logs);
        processedApplyId=0;
    }
    public String getOwnerComName() {
        return ownerComName;
    }

    public void setOwnerComName(String ownerComName) {
        this.ownerComName = ownerComName;
    }



    public void changed() {
    }

    public boolean isProcessing() {
        return processing;
    }

    public void setProcessing(boolean processing) {
        this.processing = processing;
    }



    public long getProcessedApplyId() {
        return processedApplyId;
    }

    public void setProcessedApplyId(long processedApplyId) {
        this.processedApplyId = processedApplyId;
    }


    public String getEqCode() {
        return eqCode;
    }

    public void setEqCode(String eqCode) {
        this.eqCode = eqCode;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getNoUseDate() {
        return noUseDate;
    }

    public void setNoUseDate(String noUseDate) {
        this.noUseDate = noUseDate;
    }

    public String getNoUseEndDate() {
        return noUseEndDate;
    }

    public void setNoUseEndDate(String noUseEndDate) {
        this.noUseEndDate = noUseEndDate;
    }

    public String getDisableDate() {
        return disableDate;
    }

    public void setDisableDate(String disableDate) {
        this.disableDate = disableDate;
    }

    public String getComTablePerson() {
        return comTablePerson;
    }

    public void setComTablePerson(String comTablePerson) {
        this.comTablePerson = comTablePerson;
    }

    public String getAcceptorAgencyName() {
        return acceptorAgencyName;
    }

    public void setAcceptorAgencyName(String acceptorAgencyName) {
        this.acceptorAgencyName = acceptorAgencyName;
    }

    public String getRegistPerson() {
        return registPerson;
    }

    public void setRegistPerson(String registPerson) {
        this.registPerson = registPerson;
    }

    public String getUseComName() {
        return useComName;
    }

    public void setUseComName(String useComName) {
        this.useComName = useComName;
    }

    public String getRegistCode() {
        return registCode;
    }

    public void setRegistCode(String registCode) {
        this.registCode = registCode;
    }

    public long getAgencyId() {
        return agencyId;
    }

    public long getCreateTime(){
       // return UtilServiceImpl.date2String(UtilServiceImpl.long2Date(createTime,"yyyy年MM月dd日"),"yyyy年MM月dd日");
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public DeviceTypeEnum getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceTypeEnum deviceType) {
        deviceTypeId=deviceType.ordinal();
        this.deviceType = deviceType;
    }

    public int getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(int deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }


    public List<DeviceLogs> getLogs() {
        return logs;
    }

    public void setLogs(List<DeviceLogs> logs) {
        this.logs = logs;
    }

    public String getEqUseAddr() {
        return eqUseAddr;
    }

    public void setEqUseAddr(String eqUseAddr) {
        this.eqUseAddr = eqUseAddr;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
