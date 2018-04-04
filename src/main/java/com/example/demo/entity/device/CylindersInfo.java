package com.example.demo.entity.device;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author yang
 * @create_at 17-11-10
 **/
@Entity
public class CylindersInfo implements Serializable{
    @Id@GeneratedValue
    private long id;
    private long iid;
    private long ownerId;
    private String deviceKind;
    private String eqCode;
    private String fillMedia;
    private String manufactureComName;
    private String eqCreateDate;
    private String workPressure;
    private String volume;
    private String testDate;
    private String nextTestDate;
    private String eqComCode;
    private String eqStatus;
    private String infoMessage;
    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

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

    public String getDeviceKind() {
        return deviceKind;
    }

    public void setDeviceKind(String deviceKind) {
        this.deviceKind = deviceKind;
    }

    public String getEqCode() {
        return eqCode;
    }

    public void setEqCode(String eqCode) {
        this.eqCode = eqCode;
    }

    public String getFillMedia() {
        return fillMedia;
    }

    public void setFillMedia(String fillMedia) {
        this.fillMedia = fillMedia;
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

    public void setEqCreateDate(String eqCreateDate) {
        this.eqCreateDate = eqCreateDate;
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

    public String getEqComCode() {
        return eqComCode;
    }

    public void setEqComCode(String eqComCode) {
        this.eqComCode = eqComCode;
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
}
