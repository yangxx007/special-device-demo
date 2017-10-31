package com.example.demo.entity.device;

import com.example.demo.entity.data.ApplyInfo;
import com.example.demo.enums.ApplyTypeEnum;
import com.example.demo.enums.DeviceStatesEnum;
import com.example.demo.service.Validatable;
import com.example.demo.service.staticfunction.UtilServiceImpl;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yang
 * @create_at 17-10-24
 **/
@Entity
public class DeviceInfo implements Serializable,Validatable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String deviceCode;
    private String deviceCategory;
    private String deviceClass;
    private String deviceKind;
    private DeviceStatesEnum deviceStates=DeviceStatesEnum.在用;
    private long ownerId;
    private String ownerComName;
    private long agencyId;
    private long createAt;
    private long updateAt;
    private boolean processing;
    private long processedApplyId;
    @ElementCollection(fetch = FetchType.EAGER)
    private Map<ApplyTypeEnum,String> logs=new HashMap<>();
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
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
        deviceStates=DeviceStatesEnum.报废;
    }
    public void disabled(){
        deviceStates=DeviceStatesEnum.停用;
    }
    public void enabled(){
        deviceStates=DeviceStatesEnum.在用;
    }
    public void endprocessing(){
        updateAt= UtilServiceImpl.date2Long(new Date());
        processing=false;
    }
    public void processing(long applyId){
        processing=true;
        processedApplyId=applyId;
    }
    public void addLogs(ApplyInfo applyInfo){
        logs.put(applyInfo.getApplyType(),applyInfo.getId()+"");
        processedApplyId=0;
    }
    public String getOwnerComName() {
        return ownerComName;
    }

    public void setOwnerComName(String ownerComName) {
        this.ownerComName = ownerComName;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
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

    public Map<ApplyTypeEnum, String> getLogs() {
        return logs;
    }

    public void setLogs(Map<ApplyTypeEnum, String> logs) {
        this.logs = logs;
    }
}
