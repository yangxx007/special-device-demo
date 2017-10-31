package com.example.demo.entity.form;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author yang
 * @create_at 17-10-25
 **/
@Entity
public class Form7v1 implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String eqType;
    private String productNum;
    private String fillMedia;
    private String manufactureCompany;
    private String manufactureDate;
    private Double workingPressure;
    private Double volume;
    private String lastInspectDate;
    private String nextInspectDate;
    private String companyNum;
    private String changeOrDisable;
    private String infoManage;

    public String getEqType() {
        return eqType;
    }

    public void setEqType(String eqType) {
        this.eqType = eqType;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getFillMedia() {
        return fillMedia;
    }

    public void setFillMedia(String fillMedia) {
        this.fillMedia = fillMedia;
    }

    public String getManufactureCompany() {
        return manufactureCompany;
    }

    public void setManufactureCompany(String manufactureCompany) {
        this.manufactureCompany = manufactureCompany;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Double getWorkingPressure() {
        return workingPressure;
    }

    public void setWorkingPressure(Double workingPressure) {
        this.workingPressure = workingPressure;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public String getLastInspectDate() {
        return lastInspectDate;
    }

    public void setLastInspectDate(String lastInspectDate) {
        this.lastInspectDate = lastInspectDate;
    }

    public String getNextInspectDate() {
        return nextInspectDate;
    }

    public void setNextInspectDate(String nextInspectDate) {
        this.nextInspectDate = nextInspectDate;
    }

    public String getCompanyNum() {
        return companyNum;
    }

    public void setCompanyNum(String companyNum) {
        this.companyNum = companyNum;
    }

    public String getChangeOrDisable() {
        return changeOrDisable;
    }

    public void setChangeOrDisable(String changeOrDisable) {
        this.changeOrDisable = changeOrDisable;
    }

    public String getInfoManage() {
        return infoManage;
    }

    public void setInfoManage(String infoManage) {
        this.infoManage = infoManage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
