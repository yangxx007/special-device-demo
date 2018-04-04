package com.example.demo.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class UserData implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String verifyId;
    private String useComName;
    private String useComAddr;
    private String useComCode;
    private String email;
    private String zipcode;
    private String propertyComName;
    private String propertyComCode;
    private String addressCode;
    private long acceptorAgencyId;
    private String acceptorAgencyName;
    private String safeAdministrator;
    private String staticPhone;
    private String mobilePhone;
    private String workCode;
    private boolean company;




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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVerifyId() {
        return verifyId;
    }

    public void setVerifyId(String verifyId) {
        this.verifyId = verifyId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }


    public String getSafeAdministrator() {
        return safeAdministrator;
    }

    public void setSafeAdministrator(String safeAdministrator) {
        this.safeAdministrator = safeAdministrator;
    }

    public String getWorkCode() {
        return workCode;
    }

    public void setWorkCode(String workCode) {
        this.workCode = workCode;
    }

    public boolean isCompany() {
        return company;
    }

    public void setCompany(boolean company) {
        this.company = company;
    }

    public String getStaticPhone() {
        return staticPhone;
    }

    public void setStaticPhone(String staticPhone) {
        this.staticPhone = staticPhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }


    public long getAcceptorAgencyId() {
        return acceptorAgencyId;
    }

    public void setAcceptorAgencyId(long acceptorAgencyId) {
        this.acceptorAgencyId = acceptorAgencyId;
    }

    public String getAcceptorAgencyName() {
        return acceptorAgencyName;
    }

    public void setAcceptorAgencyName(String acceptorAgencyName) {
        this.acceptorAgencyName = acceptorAgencyName;
    }
}
