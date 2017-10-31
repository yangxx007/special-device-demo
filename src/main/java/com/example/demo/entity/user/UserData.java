package com.example.demo.entity.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
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
    private String approveAgency;
    private int ApproveAgencyId;
    private String address;
    private String comPhone;
    private String comMobilePhone;




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

    public String getApproveAgency() {
        return approveAgency;
    }

    public void setApproveAgency(String approveAgency) {
        this.approveAgency = approveAgency;
    }

    public int getApproveAgencyId() {
        return ApproveAgencyId;
    }

    public void setApproveAgencyId(int approveAgencyId) {
        ApproveAgencyId = approveAgencyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComPhone() {
        return comPhone;
    }

    public void setComPhone(String comPhone) {
        this.comPhone = comPhone;
    }

    public String getComMobilePhone() {
        return comMobilePhone;
    }

    public void setComMobilePhone(String comMobilePhone) {
        this.comMobilePhone = comMobilePhone;
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
}
