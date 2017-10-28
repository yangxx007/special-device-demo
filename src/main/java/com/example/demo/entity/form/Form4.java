package com.example.demo.entity.form;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "sdProofofChange")
public class Form4 extends Form  {
    @Id
    @GeneratedValue
    private long id;
    private String number;
    private String eqSpecies;
    private String eqSpeciesCode;
    private String eqCategory;
    private String eqCategoryCode;
    private String eqVariety;
    private String eqVarietyCode;
    private String eqName;
    private String eqCode;

    private String formerRegCode;
    private String manufactureCompanyName;
    private String productNum;
    private String manufactureDate;
    private String formerUseCompanyName;
    private String formerRegIssuedDate;
    private String changeCategory;
    private String regAuthority;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public String getFormerRegCode() {
        return formerRegCode;
    }

    public void setFormerRegCode(String formerRegCode) {
        this.formerRegCode = formerRegCode;
    }

    public String getManufactureCompanyName() {
        return manufactureCompanyName;
    }

    public void setManufactureCompanyName(String manufactureCompanyName) {
        this.manufactureCompanyName = manufactureCompanyName;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getFormerUseCompanyName() {
        return formerUseCompanyName;
    }

    public void setFormerUseCompanyName(String formerUseCompanyName) {
        this.formerUseCompanyName = formerUseCompanyName;
    }

    public String getFormerRegIssuedDate() {
        return formerRegIssuedDate;
    }

    public void setFormerRegIssuedDate(String formerRegIssuedDate) {
        this.formerRegIssuedDate = formerRegIssuedDate;
    }

    public String getChangeCategory() {
        return changeCategory;
    }

    public void setChangeCategory(String changeCategory) {
        this.changeCategory = changeCategory;
    }

    public String getRegAuthority() {
        return regAuthority;
    }

    public void setRegAuthority(String regAuthority) {
        this.regAuthority = regAuthority;
    }

    public String getEqSpeciesCode() {
        return eqSpeciesCode;
    }

    public void setEqSpeciesCode(String eqSpeciesCode) {
        this.eqSpeciesCode = eqSpeciesCode;
    }

    public String getEqCategoryCode() {
        return eqCategoryCode;
    }

    public void setEqCategoryCode(String eqCategoryCode) {
        this.eqCategoryCode = eqCategoryCode;
    }

    public String getEqVarietyCode() {
        return eqVarietyCode;
    }

    public void setEqVarietyCode(String eqVarietyCode) {
        this.eqVarietyCode = eqVarietyCode;
    }
}
