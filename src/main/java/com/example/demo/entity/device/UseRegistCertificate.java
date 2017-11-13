package com.example.demo.entity.device;


import com.example.demo.service.utils.UtilServiceImpl;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author yang
 * @create_at 17-11-2
 **/
@Entity
public class UseRegistCertificate implements Serializable{
    @Id
    private String registCode;
    private String useAddress;
    private String deviceCategory;
    private String devicekind;
    private String deviceClass;
    private String useComName;
    private String eqCode;
    private String productCode;
    private String acceptorAgencyName;
    private String registDate;
    public UseRegistCertificate(){
        super();
    }
    public UseRegistCertificate(DeviceInfo deviceInfo)throws Exception{
        registCode=deviceInfo.getRegistCode();
        useAddress=deviceInfo.getEqUseAddr();
        deviceCategory=deviceInfo.getDeviceCategory();
        devicekind=deviceInfo.getDeviceKind();
        deviceClass=deviceInfo.getDeviceClass();
        useComName=deviceInfo.getUseComName();
        eqCode=deviceInfo.getEqCode();
        //不知道代表的意思
        productCode=deviceInfo.getProductCode();
        acceptorAgencyName=deviceInfo.getAcceptorAgencyName();
        setRegistDate(deviceInfo.getCreateTime());

    }
    public String getRegistCode() {
        return registCode;
    }

    public void setRegistCode(String registCode) {
        this.registCode = registCode;
    }

    public String getUseAddress() {
        return useAddress;
    }

    public void setUseAddress(String useAddress) {
        this.useAddress = useAddress;
    }

    public String getDeviceCategory() {
        return deviceCategory;
    }

    public void setDeviceCategory(String deviceCategory) {
        this.deviceCategory = deviceCategory;
    }

    public String getDevicekind() {
        return devicekind;
    }

    public void setDevicekind(String devicekind) {
        this.devicekind = devicekind;
    }

    public String getDeviceClass() {
        return deviceClass;
    }

    public void setDeviceClass(String deviceClass) {
        this.deviceClass = deviceClass;
    }

    public String getUseComName() {
        return useComName;
    }

    public void setUseComName(String useComName) {
        this.useComName = useComName;
    }

    public String getEqCode() {
        return eqCode;
    }

    public void setEqCode(String eqCode) {
        this.eqCode = eqCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getAcceptorAgencyName() {
        return acceptorAgencyName;
    }

    public void setAcceptorAgencyName(String acceptorAgencyName) {
        this.acceptorAgencyName = acceptorAgencyName;
    }

    public String getRegistDate() {
        return registDate;
    }

    public void setRegistDate(long registDate) throws Exception{
        this.registDate = UtilServiceImpl.long2String(registDate,"yyyy年MM月dd日");
    }

}
