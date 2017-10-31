package com.example.demo.entity.form;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sdregistration3")
public class Form3 extends Form  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    private String registKind;

    private String eqCategory;
    private String eqCategoryCode;
    private String eqVariety;
    private String eqVarietyCode;
    private String eqName;
    private String eqCode;

    private String usingCompanyName;
    private String usingCompanyAddr;
    private String eqUseLoc;
    private String comPhone;
    private String usingCompanyCode;
    private String zipCode;
    private String safetyAdministrator;
    private String mobileNumber;

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

    public String getUsingCompanyName() {
        return usingCompanyName;
    }

    public void setUsingCompanyName(String usingCompanyName) {
        this.usingCompanyName = usingCompanyName;
    }

    public String getUsingCompanyAddr() {
        return usingCompanyAddr;
    }

    public void setUsingCompanyAddr(String usingCompanyAddr) {
        this.usingCompanyAddr = usingCompanyAddr;
    }

    public String getEqUseLoc() {
        return eqUseLoc;
    }

    public void setEqUseLoc(String eqUseLoc) {
        this.eqUseLoc = eqUseLoc;
    }

    public String getComPhone() {
        return comPhone;
    }

    public void setComPhone(String comPhone) {
        this.comPhone = comPhone;
    }

    public String getUsingCompanyCode() {
        return usingCompanyCode;
    }

    public void setUsingCompanyCode(String usingCompanyCode) {
        this.usingCompanyCode = usingCompanyCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getSafetyAdministrator() {
        return safetyAdministrator;
    }

    public void setSafetyAdministrator(String safetyAdministrator) {
        this.safetyAdministrator = safetyAdministrator;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
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

    public String getEqCategory() {
        return eqCategory;
    }

    public void setEqCategory(String eqCategory) {
        this.eqCategory = eqCategory;
    }

    public String getEqCategoryCode() {
        return eqCategoryCode;
    }

    public void setEqCategoryCode(String eqCategoryCode) {
        this.eqCategoryCode = eqCategoryCode;
    }

    public String getEqVariety() {
        return eqVariety;
    }

    public void setEqVariety(String eqVariety) {
        this.eqVariety = eqVariety;
    }

    public String getEqVarietyCode() {
        return eqVarietyCode;
    }

    public void setEqVarietyCode(String eqVarietyCode) {
        this.eqVarietyCode = eqVarietyCode;
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
}
