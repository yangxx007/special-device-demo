package com.example.demo.entity.form;

import com.example.demo.entity.data.ApplyInfo;
import com.example.demo.service.utils.UtilServiceImpl;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author yang
 * @create_at 17-11-8
 **/
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistForm implements Serializable {
    @Id
    private String registCode;
    private long registTypeId;
    private String registType;
    private String deviceCategory;
    private String deviceClass;
    private String deviceKind;
    @Column(unique = true)
    private String eqComCode;
    private String eqCode;
    private String useComName;
    private String eqUseAddr;
    private String createTime;
    private String acceptorAgencyName;
    public RegistForm(ApplyInfo applyInfo){
        if(applyInfo.getRegistCode()!=null){
            registCode=applyInfo.getRegistCode();
        }else {
        }
    }

    public String getRegistCode() {
        return registCode;
    }

    public void setRegistCode(String registCode) {
        this.registCode = registCode;
    }

    public long getRegistTypeId() {
        return registTypeId;
    }

    public void setRegistTypeId(long registTypeId) {
        this.registTypeId = registTypeId;
    }

    public String getRegistType() {
        return registType;
    }

    public void setRegistType(String registType) {
        this.registType = registType;
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

    public String getEqComCode() {
        return eqComCode;
    }

    public void setEqComCode(String eqComCode) {
        this.eqComCode = eqComCode;
    }

    public String getEqCode() {
        return eqCode;
    }

    public void setEqCode(String eqCode) {
        this.eqCode = eqCode;
    }

    public String getUseComName() {
        return useComName;
    }

    public void setUseComName(String useComName) {
        this.useComName = useComName;
    }

    public String getEqUseAddr() {
        return eqUseAddr;
    }

    public void setEqUseAddr(String eqUseAddr) {
        this.eqUseAddr = eqUseAddr;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAcceptorAgencyName() {
        return acceptorAgencyName;
    }

    public void setAcceptorAgencyName(String acceptorAgencyName) {
        this.acceptorAgencyName = acceptorAgencyName;
    }
}
