package com.example.demo.entity.form;

import com.example.demo.enums.DeviceTypeEnum;
import com.example.demo.service.utils.UtilServiceImpl;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yang
 * @create_at 17-11-3
 **/
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubForm implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long iid;
    private long ownerId;
    private DeviceTypeEnum deviceType;
    private String registCode;
    private String eqUseAddr;
    private String reasons;
    private String pipeName;
    private String eqCode;
    private String eqLevel;
    private String designComName;
    private String constructComName;
    private String eqUseDate;
    private String diameter;
    private String thickness;
    private String length;
    private String temperature;
    private String testResult;
    private String testComName;
    private String remark;
    private String deviceKind;
    private String fillMedia;
    private String workPressure;
    private String volume;
    private String testDate;
    private String nextTestDate;
    private String eqStatus;
    private String infoMessage;
    private String manufactureComName;
    private String eqCreateDate;
    private String productCode;
    private String eqComCode;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIid() {
        return iid;
    }

    public void setIid(long iid) {
        this.iid = iid;
    }

    public String getRegistCode() {
        return registCode;
    }

    public void setRegistCode(String registCode) {
        this.registCode = registCode;
    }

    public String getEqUseAddr() {
        return eqUseAddr;
    }

    public void setEqUseAddr(String eqUseAddr) {
        this.eqUseAddr = eqUseAddr;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
    }

    public String getPipeName() {
        return pipeName;
    }

    public void setPipeName(String pipeName) {
        this.pipeName = pipeName;
    }

    public String getEqCode() {
        return eqCode;
    }

    public void setEqCode(String eqCode) {
        this.eqCode = eqCode;
    }

    public String getEqLevel() {
        return eqLevel;
    }

    public void setEqLevel(String eqLevel) {
        this.eqLevel = eqLevel;
    }

    public String getDesignComName() {
        return designComName;
    }

    public void setDesignComName(String designComName) {
        this.designComName = designComName;
    }

    public String getConstructComName() {
        return constructComName;
    }

    public void setConstructComName(String constructComName) {
        this.constructComName = constructComName;
    }

    public String getEqUseDate() {
        return eqUseDate;
    }

    public void setEqUseDate(String eqUseDate) {
        this.eqUseDate = eqUseDate;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }


    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getTestComName() {
        return testComName;
    }

    public void setTestComName(String testComName) {
        this.testComName = testComName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDeviceKind() {
        return deviceKind;
    }

    public void setDeviceKind(String deviceKind) {
        this.deviceKind = deviceKind;
    }

    public String getFillMedia() {
        return fillMedia;
    }

    public void setFillMedia(String fillMedia) {
        this.fillMedia = fillMedia;
    }

    public String getWorkPressure() {
        return workPressure;
    }

    public void setWorkPressure(String workPressure) {
        this.workPressure = workPressure;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getEqStatus() {
        return eqStatus;
    }

    public void setEqStatus(String eqStatus) {
        this.eqStatus = eqStatus;
    }

    public String getInfoMessage() {
        return infoMessage;
    }

    public void setInfoMessage(String infoMessage) {
        this.infoMessage = infoMessage;
    }

    public String getManufactureComName() {
        return manufactureComName;
    }

    public void setManufactureComName(String manufactureComName) {
        this.manufactureComName = manufactureComName;
    }

    public String getEqCreateDate() {
        return eqCreateDate;
    }

    public void setEqCreateDate(Date eqCreateDate) {
        this.eqCreateDate = UtilServiceImpl.date2String(eqCreateDate,"yyyy年MM月dd日");
    }
    public void setEqCreateDateStr(String eqCreateDate) {
        this.eqCreateDate =eqCreateDate;
    }
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getEqComCode() {
        return eqComCode;
    }

    public void setEqComCode(String eqComCode) {
        this.eqComCode = eqComCode;
    }

    public String getThickness() {
        return thickness;
    }

    public void setThickness(String thickness) {
        this.thickness = thickness;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public String getNextTestDate() {
        return nextTestDate;
    }

    public void setNextTestDate(String nextTestDate) {
        this.nextTestDate = nextTestDate;
    }

    public DeviceTypeEnum getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceTypeEnum deviceType) {
        this.deviceType = deviceType;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }
}
