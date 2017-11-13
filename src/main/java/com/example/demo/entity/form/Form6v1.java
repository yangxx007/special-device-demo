package com.example.demo.entity.form;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.SortedSet;

/**
 * @author yang
 * @create_at 17-10-25
 **/
@Entity
public class Form6v1 implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long inlineId;
    private String pipeName;
    private String pipeNum;
    private String pipeLevel;
    private String designCompany;
    private String installCompany;
    private String installDate;
    private String useDate;
    private Double diameter;
    private Double wallThickness;
    private Double pipeLength;
    private String pressure;
    private String temperature;
    private String medium;
    private String testResult;
    private String inspectionAgency;
    private String nextTestDate;
    private String remark;

    public String getPipeName() {
        return pipeName;
    }

    public void setPipeName(String pipeName) {
        this.pipeName = pipeName;
    }

    public String getPipeNum() {
        return pipeNum;
    }

    public void setPipeNum(String pipeNum) {
        this.pipeNum = pipeNum;
    }

    public String getPipeLevel() {
        return pipeLevel;
    }

    public void setPipeLevel(String pipeLevel) {
        this.pipeLevel = pipeLevel;
    }

    public String getDesignCompany() {
        return designCompany;
    }

    public void setDesignCompany(String designCompany) {
        this.designCompany = designCompany;
    }

    public String getInstallCompany() {
        return installCompany;
    }

    public void setInstallCompany(String installCompany) {
        this.installCompany = installCompany;
    }

    public String getInstallDate() {
        return installDate;
    }

    public void setInstallDate(String installDate) {
        this.installDate = installDate;
    }

    public String getUseDate() {
        return useDate;
    }

    public void setUseDate(String useDate) {
        this.useDate = useDate;
    }

    public Double getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = Double.parseDouble(diameter);
    }

    public Double getWallThickness() {
        return wallThickness;
    }

    public void setWallThickness(String wallThickness) {
        this.wallThickness = Double.parseDouble(wallThickness);
    }

    public Double getPipeLength() {
        return pipeLength;
    }

    public void setPipeLength(String pipeLength) {
        this.pipeLength = Double.parseDouble(pipeLength);
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getInspectionAgency() {
        return inspectionAgency;
    }

    public void setInspectionAgency(String inspectionAgency) {
        this.inspectionAgency = inspectionAgency;
    }

    public String getNextTestDate() {
        return nextTestDate;
    }

    public void setNextTestDate(String nextTestDate) {
        this.nextTestDate = nextTestDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getInlineId() {
        return inlineId;
    }

    public void setInlineId(long inlineId) {
        this.inlineId = inlineId;
    }
}
