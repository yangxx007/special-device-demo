package com.example.demo.entity.device;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author yang
 * @create_at 17-11-10
 **/
@Entity
public class PipesInfo implements Serializable {
    @Id
    private long id;
    private long iid;
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
    private String fillMedia;
    private String workPressure;
    private String nextTestDate;
    private String eqCreateDate;


    public long getIid() {
        return iid;
    }

    public void setIid(long iid) {
        this.iid = iid;
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

    public String getNextTestDate() {
        return nextTestDate;
    }

    public void setNextTestDate(String nextTestDate) {
        this.nextTestDate = nextTestDate;
    }

    public String getEqCreateDate() {
        return eqCreateDate;
    }

    public void setEqCreateDate(String eqCreateDate) {
        this.eqCreateDate = eqCreateDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
