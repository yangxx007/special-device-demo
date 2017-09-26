package com.example.demo.entity.formModel;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Form1 implements Serializable{
    @Id
    @GeneratedValue
    private long id;
    private String deviceType;
    private String deviceClass;
    private String deviceVarieties;
    private String productName;
    private String deviceCode;
    private String modelSpecifications;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceClass() {
        return deviceClass;
    }

    public void setDeviceClass(String deviceClass) {
        this.deviceClass = deviceClass;
    }

    public String getDeviceVarieties() {
        return deviceVarieties;
    }

    public void setDeviceVarieties(String deviceVarieties) {
        this.deviceVarieties = deviceVarieties;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getModelSpecifications() {
        return modelSpecifications;
    }

    public void setModelSpecifications(String modelSpecifications) {
        this.modelSpecifications = modelSpecifications;
    }
}
