package com.example.demo.entity.formModel;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "sdregistration1")
public class Form1 implements Serializable{
    @Id
    @GeneratedValue
    private long id;

    private String registKind;

    private String eqSpecies;
    private String eqCategory;
    private String eqVariety;
    private String eqName;
    private String eqCode;
    private String model;
    private String designUseLimit;
    private String designComName;
    private String manufactureComName;
    private String constructComName;
    private String superviseComName;
    private String testComName;

    private String useComName;
    private String useComAddr;
    private String useComCode;
    private String zipCode;
    private String comCode;
    private String eqUseLocation;
    private String beginUseDate;
    private String comPhone;
    private String safeAdmin;
    private String mobilePhone;
    private String propertyComName;
    private String propertyComCode;
    private String telephone;

    private String checkComName;
    private String checkCategory;
    private String checkReportNum;
    private String checkDate;
    private String checkConclusion;
    private String nextCheckDate;

    private String comTablePerson;
    private String comDate1;
    private String comSafePerson;
    private String comDate2;

    private String regisPerson;
    private String comDate3;
    private String registCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRegistKind() {
        return registKind;
    }

    public void setRegistKind(String registKind) {
        this.registKind = registKind;
    }

    public String getEqSpecies() {
        return eqSpecies;
    }

    public void setEqSpecies(String eqSpecies) {
        this.eqSpecies = eqSpecies;
    }

    public String getEqCategory() {
        return eqCategory;
    }

    public void setEqCategory(String eqCategory) {
        this.eqCategory = eqCategory;
    }

    public String getEqVariety() {
        return eqVariety;
    }

    public void setEqVariety(String eqVariety) {
        this.eqVariety = eqVariety;
    }

    public String getEqName() {
        return eqName;
    }

    public void setEqName(String eqName) {
        this.eqName = eqName;
    }

    public String getEqCode() {
        return eqCode;
    }

    public void setEqCode(String eqCode) {
        this.eqCode = eqCode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDesignUseLimit() {
        return designUseLimit;
    }

    public void setDesignUseLimit(String designUseLimit) {
        this.designUseLimit = designUseLimit;
    }

    public String getDesignComName() {
        return designComName;
    }

    public void setDesignComName(String designComName) {
        this.designComName = designComName;
    }

    public String getManufactureComName() {
        return manufactureComName;
    }

    public void setManufactureComName(String manufactureComName) {
        this.manufactureComName = manufactureComName;
    }

    public String getConstructComName() {
        return constructComName;
    }

    public void setConstructComName(String constructComName) {
        this.constructComName = constructComName;
    }

    public String getSuperviseComName() {
        return superviseComName;
    }

    public void setSuperviseComName(String superviseComName) {
        this.superviseComName = superviseComName;
    }

    public String getTestComName() {
        return testComName;
    }

    public void setTestComName(String testComName) {
        this.testComName = testComName;
    }

    public String getUseComName() {
        return useComName;
    }

    public void setUseComName(String useComName) {
        this.useComName = useComName;
    }

    public String getUseComAddr() {
        return useComAddr;
    }

    public void setUseComAddr(String useComAddr) {
        this.useComAddr = useComAddr;
    }

    public String getUseComCode() {
        return useComCode;
    }

    public void setUseComCode(String useComCode) {
        this.useComCode = useComCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getEqUseLocation() {
        return eqUseLocation;
    }

    public void setEqUseLocation(String eqUseLocation) {
        this.eqUseLocation = eqUseLocation;
    }

    public String getBeginUseDate() {
        return beginUseDate;
    }

    public void setBeginUseDate(String beginUseDate) {
        this.beginUseDate = beginUseDate;
    }

    public String getComPhone() {
        return comPhone;
    }

    public void setComPhone(String comPhone) {
        this.comPhone = comPhone;
    }

    public String getSafeAdmin() {
        return safeAdmin;
    }

    public void setSafeAdmin(String safeAdmin) {
        this.safeAdmin = safeAdmin;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPropertyComName() {
        return propertyComName;
    }

    public void setPropertyComName(String propertyComName) {
        this.propertyComName = propertyComName;
    }

    public String getPropertyComCode() {
        return propertyComCode;
    }

    public void setPropertyComCode(String propertyComCode) {
        this.propertyComCode = propertyComCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCheckComName() {
        return checkComName;
    }

    public void setCheckComName(String checkComName) {
        this.checkComName = checkComName;
    }

    public String getCheckCategory() {
        return checkCategory;
    }

    public void setCheckCategory(String checkCategory) {
        this.checkCategory = checkCategory;
    }

    public String getCheckReportNum() {
        return checkReportNum;
    }

    public void setCheckReportNum(String checkReportNum) {
        this.checkReportNum = checkReportNum;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckConclusion() {
        return checkConclusion;
    }

    public void setCheckConclusion(String checkConclusion) {
        this.checkConclusion = checkConclusion;
    }

    public String getNextCheckDate() {
        return nextCheckDate;
    }

    public void setNextCheckDate(String nextCheckDate) {
        this.nextCheckDate = nextCheckDate;
    }

    public String getComTablePerson() {
        return comTablePerson;
    }

    public void setComTablePerson(String comTablePerson) {
        this.comTablePerson = comTablePerson;
    }

    public String getComDate1() {
        return comDate1;
    }

    public void setComDate1(String comDate1) {
        this.comDate1 = comDate1;
    }

    public String getComSafePerson() {
        return comSafePerson;
    }

    public void setComSafePerson(String comSafePerson) {
        this.comSafePerson = comSafePerson;
    }

    public String getComDate2() {
        return comDate2;
    }

    public void setComDate2(String comDate2) {
        this.comDate2 = comDate2;
    }

    public String getRegisPerson() {
        return regisPerson;
    }

    public void setRegisPerson(String regisPerson) {
        this.regisPerson = regisPerson;
    }

    public String getComDate3() {
        return comDate3;
    }

    public void setComDate3(String comDate3) {
        this.comDate3 = comDate3;
    }

    public String getRegistCode() {
        return registCode;
    }

    public void setRegistCode(String registCode) {
        this.registCode = registCode;
    }








}
