package com.example.demo.entity.form;

import com.example.demo.enums.FormTypeEnum;
import com.example.demo.service.utils.UtilServiceImpl;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.rmi.CORBA.Util;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author yang
 * @create_at 17-10-23
 **/
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Form implements Serializable {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private FormTypeEnum formType;
    private String acceptorAgencyName;
    private int acceptorAgencyId;
    private String deviceCategory;
    private String deviceCategoryCode;
    private String deviceClass;
    private String deviceClassCode;
    private String deviceKindCode;
    private String eqCode;
    private String designUseLimit;
    private String designComName;
    private String modelTestComName;
    private String propertyComName;
    private String propertyComCode;
    private String registKind;

    private String propertyComPhone;
    private String testComName;
    private String testType;
    private String testReportCode;
    private String testDate;
    private String testResult;
    private String nextTestDate;
    private String deviceKind;

    private String deviceNum;
    private String fillMedia;
    private String workPressure;
    private String model;

    private String manufactureComName;

    private String eqComCode;
    private String constructComName;
    private String superviseComName;
    private String useComName;
    private String useComAddr;
    private String carNum;
    private String carVin;
    private String eqUseDate;
    private String safeAdministrator;
    private String eqUseAddr;
    private String staticPhone;
    private String useComCode;
    private String zipcode;
    private String mobilePhone;
    private String formCreateDate;
    private String comTablePerson;
    private String deviceName;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "FormSubForms",joinColumns = {@JoinColumn(name = "formId")},inverseJoinColumns = {@JoinColumn(name ="subFormId")})
    private List<SubForm> subList;
    private String registCode;
    private String manufatureComName;
    private String productCode;
    private String eqCreateDate;
    private String origUseComName;
    private String registDate;
    private String changedType;
    private String telephone;
    private String email;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }





    public String getDeviceClass() {
        return deviceClass;
    }

    public void setDeviceClass(String deviceClass) {
        this.deviceClass = deviceClass.replaceAll("\n","").trim();
    }

    public String getEqCode() {
        return eqCode;
    }

    public void setEqCode(String eqCode) {
        this.eqCode = eqCode;
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

    public String getModelTestComName() {
        return modelTestComName;
    }

    public void setModelTestComName(String modelTestComName) {
        this.modelTestComName = modelTestComName;
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

    public String getPropertyComPhone() {
        return propertyComPhone;
    }

    public void setPropertyComPhone(String propertyComPhone) {
        this.propertyComPhone = propertyComPhone;
    }

    public String getTestComName() {
        return testComName;
    }

    public void setTestComName(String testComName) {
        this.testComName = testComName;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getTestReportCode() {
        return testReportCode;
    }

    public void setTestReportCode(String testReportCode) {
        this.testReportCode = testReportCode;
    }

    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate){

        this.testDate = date2String(testDate);
    }
//    public void setTestDate(String testDate){
//
//        this.testDate = testDate;
//    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getNextTestDate() {
        return nextTestDate;
    }

    public void setNextTestDate(Date nextTestDate) {
        this.nextTestDate = date2String(nextTestDate);
    }
//    public void setNextTestDate(String  nextTestDate) {
//        this.nextTestDate = nextTestDate;
//    }


    public String getDeviceKind() {
        return deviceKind;
    }

    public void setDeviceKind(String deviceKind) {
        this.deviceKind = deviceKind.replaceAll("\n","").trim();
    }

    public String getDeviceNum() {
        return deviceNum;
    }

    public void setDeviceNum(String deviceNum) {
        this.deviceNum = deviceNum;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufactureComName() {
        return manufactureComName;
    }

    public void setManufactureComName(String manufactureComName) {
        this.manufactureComName = manufactureComName;
    }

    public String getEqComCode() {
        return eqComCode;
    }

    public void setEqComCode(String eqComCode) {
        this.eqComCode = eqComCode;
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

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getCarVin() {
        return carVin;
    }

    public void setCarVin(String carVin) {
        this.carVin = carVin;
    }

    public String getEqUseDate() {
        return eqUseDate;
    }

    public void setEqUseDate(Date eqUseDate) {
        this.eqUseDate = date2String(eqUseDate);
    }
//    public void setEqUseDate(String eqUseDate) {
//        this.eqUseDate = eqUseDate;
//    }

    public String getEqUseAddr() {
        return eqUseAddr;
    }

    public void setEqUseAddr(String eqUseAddr) {
        this.eqUseAddr = eqUseAddr;
    }

    public String getStaticPhone() {
        return staticPhone;
    }

    public void setStaticPhone(String staticPhone) {
        this.staticPhone = staticPhone;
    }

    public String getUseComCode() {
        return useComCode;
    }

    public void setUseComCode(String useComCode) {
        this.useComCode = useComCode;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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

    public String getFormCreateDate() {
        return formCreateDate;
    }

    public void setFormCreateDate(Date formCreateDate) {
        this.formCreateDate =date2String(formCreateDate);
    }
//    public void setFormCreateDate(String formCreateDate){
//        this.formCreateDate=formCreateDate;
//    }

    public String getComTablePerson() {
        return comTablePerson;
    }

    public void setComTablePerson(String comTablePerson) {
        this.comTablePerson = comTablePerson;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public List<SubForm> getSubList() {
        return subList;
    }

    public void setSubList(List<SubForm> subList) {
        this.subList = subList;
    }

    public String getRegistCode() {
        return registCode;
    }

    public void setRegistCode(String registCode) {
        this.registCode = registCode;
    }

    public String getManufatureComName() {
        return manufatureComName;
    }

    public void setManufatureComName(String manufatureComName) {
        this.manufatureComName = manufatureComName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getEqCreateDate() {
        return eqCreateDate;
    }

    public void setEqCreateDate(Date eqCreateDate) {
        this.eqCreateDate = date2String(eqCreateDate);
    }
//    public void setEqCreateDate(String eqCreateDate) {
//        this.eqCreateDate =eqCreateDate;
//    }

    public String getOrigUseComName() {
        return origUseComName;
    }

    public void setOrigUseComName(String origUseComName) {
        this.origUseComName = origUseComName;
    }

    public String getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = date2String(registDate);
    }
//    public void setRegistDate(String registDate) {
//        this.registDate = registDate;
//    }

    public String getChangedType() {
        return changedType;
    }

    public void setChangedType(String changedType) {
        this.changedType = changedType;
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

    public FormTypeEnum getFormType() {
        return formType;
    }

    public void setFormType(FormTypeEnum formType) {
        this.formType = formType;
    }

    public String getDeviceCategory() {
        return deviceCategory;
    }

    public void setDeviceCategory(String deviceCategory) {
        this.deviceCategory = deviceCategory.trim().replaceAll("\n","");
    }

    public String getAcceptorAgencyName() {
        return acceptorAgencyName;
    }

    public void setAcceptorAgencyName(String acceptorAgencyName) {
        this.acceptorAgencyName = acceptorAgencyName;
    }



    public String getDeviceCategoryCode() {
        return deviceCategoryCode;
    }

    public void setDeviceCategoryCode(String deviceCategoryCode) {
        this.deviceCategoryCode = deviceCategoryCode;
    }

    public String getDeviceClassCode() {
        return deviceClassCode;
    }

    public void setDeviceClassCode(String deviceClassCode) {
        this.deviceClassCode = deviceClassCode;
    }

    public String getDeviceKindCode() {
        return deviceKindCode;
    }

    public void setDeviceKindCode(String deviceKindCode) {
        this.deviceKindCode = deviceKindCode;
    }

    public String getRegistKind() {
        return registKind;
    }

    public void setRegistKind(String registKind) {
        this.registKind = registKind;
    }

    public int getAcceptorAgencyId() {
        return acceptorAgencyId;
    }

    public void setAcceptorAgencyId(int acceptorAgencyId) {
        this.acceptorAgencyId = acceptorAgencyId;
    }

    public void addSubList(List<SubForm> forms){
        subList.addAll(forms);
    }
    private String date2String(Date date){
        try{
            return UtilServiceImpl.date2String(date,"yyyy年MM月dd日");
        }
        catch (Exception e){
            return null;
        }
    }

}
