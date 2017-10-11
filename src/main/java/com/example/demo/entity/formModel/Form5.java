package com.example.demo.entity.formModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "sdCancellationofRe")
public class Form5 implements Serializable {
    @Id
    @GeneratedValue
    private long  id;
    private String declarationType;
    private String useCompanyName;
    private String useCompanyAddr;
    private String securityAdmin;
    private String securityAdminTel;
    private String propertyCompanyName;
    private String propertyCompanyTel;
    private String serialNumber;
    private String eqVariety;
    private String useRegCode;
    private String eqCode;
    private String eqUseLoc;
    private String productNum;
    private String cancelReason;
    private String useCompanyOpinion;
    private String propertyCompanyOpinion;
    private String regAuthorityOpinion;
    private String regAuthorityStaff;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDeclarationType() {
        return declarationType;
    }

    public void setDeclarationType(String declarationType) {
        this.declarationType = declarationType;
    }

    public String getUseCompanyName() {
        return useCompanyName;
    }

    public void setUseCompanyName(String useCompanyName) {
        this.useCompanyName = useCompanyName;
    }

    public String getUseCompanyAddr() {
        return useCompanyAddr;
    }

    public void setUseCompanyAddr(String useCompanyAddr) {
        this.useCompanyAddr = useCompanyAddr;
    }

    public String getSecurityAdmin() {
        return securityAdmin;
    }

    public void setSecurityAdmin(String securityAdmin) {
        this.securityAdmin = securityAdmin;
    }

    public String getSecurityAdminTel() {
        return securityAdminTel;
    }

    public void setSecurityAdminTel(String securityAdminTel) {
        this.securityAdminTel = securityAdminTel;
    }

    public String getPropertyCompanyName() {
        return propertyCompanyName;
    }

    public void setPropertyCompanyName(String propertyCompanyName) {
        this.propertyCompanyName = propertyCompanyName;
    }

    public String getPropertyCompanyTel() {
        return propertyCompanyTel;
    }

    public void setPropertyCompanyTel(String propertyCompanyTel) {
        this.propertyCompanyTel = propertyCompanyTel;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getEqVariety() {
        return eqVariety;
    }

    public void setEqVariety(String eqVariety) {
        this.eqVariety = eqVariety;
    }

    public String getUseRegCode() {
        return useRegCode;
    }

    public void setUseRegCode(String useRegCode) {
        this.useRegCode = useRegCode;
    }

    public String getEqCode() {
        return eqCode;
    }

    public void setEqCode(String eqCode) {
        this.eqCode = eqCode;
    }

    public String getEqUseLoc() {
        return eqUseLoc;
    }

    public void setEqUseLoc(String eqUseLoc) {
        this.eqUseLoc = eqUseLoc;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getUseCompanyOpinion() {
        return useCompanyOpinion;
    }

    public void setUseCompanyOpinion(String useCompanyOpinion) {
        this.useCompanyOpinion = useCompanyOpinion;
    }

    public String getPropertyCompanyOpinion() {
        return propertyCompanyOpinion;
    }

    public void setPropertyCompanyOpinion(String propertyCompanyOpinion) {
        this.propertyCompanyOpinion = propertyCompanyOpinion;
    }

    public String getRegAuthorityOpinion() {
        return regAuthorityOpinion;
    }

    public void setRegAuthorityOpinion(String regAuthorityOpinion) {
        this.regAuthorityOpinion = regAuthorityOpinion;
    }

    public String getRegAuthorityStaff() {
        return regAuthorityStaff;
    }

    public void setRegAuthorityStaff(String regAuthorityStaff) {
        this.regAuthorityStaff = regAuthorityStaff;
    }
}
