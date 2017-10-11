package com.example.demo.entity.formModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "IndustrialPiping")
public class Form6 implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String useCompany;
    private String useCompanyAdd;
    private String engineeringDevice;
    private String safetyDepartment;
    private String securityAdmin;
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
    private String formFillDate;
    private String manager;
    private String telephone;
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUseCompany() {
        return useCompany;
    }

    public void setUseCompany(String useCompany) {
        this.useCompany = useCompany;
    }

    public String getUseCompanyAdd() {
        return useCompanyAdd;
    }

    public void setUseCompanyAdd(String useCompanyAdd) {
        this.useCompanyAdd = useCompanyAdd;
    }

    public String getEngineeringDevice() {
        return engineeringDevice;
    }

    public void setEngineeringDevice(String engineeringDevice) {
        this.engineeringDevice = engineeringDevice;
    }

    public String getSafetyDepartment() {
        return safetyDepartment;
    }

    public void setSafetyDepartment(String safetyDepartment) {
        this.safetyDepartment = safetyDepartment;
    }

    public String getSecurityAdmin() {
        return securityAdmin;
    }

    public void setSecurityAdmin(String securityAdmin) {
        this.securityAdmin = securityAdmin;
    }

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

    public void setDiameter(Double diameter) {
        this.diameter = diameter;
    }

    public Double getWallThickness() {
        return wallThickness;
    }

    public void setWallThickness(Double wallThickness) {
        this.wallThickness = wallThickness;
    }

    public Double getPipeLength() {
        return pipeLength;
    }

    public void setPipeLength(Double pipeLength) {
        this.pipeLength = pipeLength;
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

    public String getFormFillDate() {
        return formFillDate;
    }

    public void setFormFillDate(String formFillDate) {
        this.formFillDate = formFillDate;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
