package com.example.demo.entity.form;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sdregistration2")
public class Form2 extends Form  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String registKind;

    private String eqSpecies;
    private String eqSpeciesCode;
    private String productName;
    private String cylinderNum;
    private String fillMedium;
    private String cylinderWorkPressure;
    private String cylinderVolume;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "applyCarCylinders",joinColumns = {@JoinColumn(name = "formId")},inverseJoinColumns = {@JoinColumn(name ="deviceId")})
    private List<Form2v1> subList;


    private String constrComName;
    private String inspectComName;

    private String useCompanyName;
    private String useCompanyAddr;
    private String useCompanyCode;
    private String zipcode;
    private String license;
    private String vin;
    private String beginToUseDate;
    private String companyPhone;
    private String safeAdministrator;
    private String mobilePhone;

    private String comTablePerson;
    private String comDate1;
    private String comSafePerson;
    private String comDate2;

    private String regisPerson;
    private String comDate3;
    private String registCode;

    public String getRegistKind() {
        return registKind;
    }

    public void setRegistKind(String registKind) {
        this.registKind = registKind;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCylinderNum() {
        return cylinderNum;
    }

    public void setCylinderNum(String cylinderNum) {
        this.cylinderNum = cylinderNum;
    }

    public String getFillMedium() {
        return fillMedium;
    }

    public void setFillMedium(String fillMedium) {
        this.fillMedium = fillMedium;
    }

    public String getCylinderWorkPressure() {
        return cylinderWorkPressure;
    }

    public void setCylinderWorkPressure(String cylinderWorkPressure) {
        this.cylinderWorkPressure = cylinderWorkPressure;
    }

    public String getCylinderVolume() {
        return cylinderVolume;
    }

    public void setCylinderVolume(String cylinderVolume) {
        this.cylinderVolume = cylinderVolume;
    }

    public String getConstrComName() {
        return constrComName;
    }

    public void setConstrComName(String constrComName) {
        this.constrComName = constrComName;
    }

    public String getInspectComName() {
        return inspectComName;
    }

    public void setInspectComName(String inspectComName) {
        this.inspectComName = inspectComName;
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

    public String getUseCompanyCode() {
        return useCompanyCode;
    }

    public void setUseCompanyCode(String useCompanyCode) {
        this.useCompanyCode = useCompanyCode;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getBeginToUseDate() {
        return beginToUseDate;
    }

    public void setBeginToUseDate(String beginToUseDate) {
        this.beginToUseDate = beginToUseDate;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getSafeAdministrator() {
        return safeAdministrator;
    }

    public void setSafeAdministrator(String safeAdministrator) {
        this.safeAdministrator = safeAdministrator;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
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

    public String getEqSpecies() {
        return eqSpecies;
    }

    public void setEqSpecies(String eqSpecies) {
        this.eqSpecies = eqSpecies;
    }

    public String getEqSpeciesCode() {
        return eqSpeciesCode;
    }

    public void setEqSpeciesCode(String eqSpeciesCode) {
        this.eqSpeciesCode = eqSpeciesCode;
    }


    public List<Form2v1> getSubList() {
        return subList;
    }

    public void setSubList(List<Form2v1> subList) {
        this.subList = subList;
    }
}
