package com.example.demo.connector.updater;


import com.example.demo.entity.data.ApplyInfo;
import com.example.demo.entity.form.*;
import com.example.demo.service.staticfunction.UtilServiceImpl;

import javax.rmi.CORBA.Util;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author yang
 * @create_at 17-10-26
 **/
public class ApplyUpdater implements Serializable {
    private long id;

    public String getDeviceClass() {
        return deviceClass;
    }

    public void setDeviceClass(String deviceClass) {
        this.deviceClass = deviceClass;
    }

    public String getDeviceKind() {
        return deviceKind;
    }

    public void setDeviceKind(String deviceKind) {
        this.deviceKind = deviceKind;
    }

    private String deviceClass;
    private String deviceKind;
    private String deviceName;
    private String deviceCode;
    private Form1 form1;
    private Form2 form2;
    private Form3 form3;

    private Form4 form4;

    private Form5 form5;

    private Form6 form6;

    private Form7 form7;
    public void update(ApplyInfo applyInfo){
        applyInfo.setForm1(form1);
        applyInfo.setForm2(form2);
        applyInfo.setForm3(form3);
        applyInfo.setForm4(form4);
        applyInfo.setForm5(form5);
        applyInfo.setForm6(form6);
        applyInfo.setForm7(form7);
        applyInfo.setDeviceClass(deviceClass);
        applyInfo.setDeviceKind(deviceKind);
        applyInfo.setDeviceCode(deviceCode);
        applyInfo.setDeviceName(deviceName);
        applyInfo.setCreateTime(UtilServiceImpl.date2Long(new Date()));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Form1 getForm1() {
        return form1;
    }

    public void setForm1(Form1 form1) {
        this.form1 = form1;
    }

    public Form2 getForm2() {
        return form2;
    }

    public void setForm2(Form2 form2) {
        this.form2 = form2;
    }

    public Form3 getForm3() {
        return form3;
    }

    public void setForm3(Form3 form3) {
        this.form3 = form3;
    }

    public Form4 getForm4() {
        return form4;
    }

    public void setForm4(Form4 form4) {
        this.form4 = form4;
    }

    public Form5 getForm5() {
        return form5;
    }

    public void setForm5(Form5 form5) {
        this.form5 = form5;
    }

    public Form6 getForm6() {
        return form6;
    }

    public void setForm6(Form6 form6) {
        this.form6 = form6;
    }

    public Form7 getForm7() {
        return form7;
    }

    public void setForm7(Form7 form7) {
        this.form7 = form7;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }
}
