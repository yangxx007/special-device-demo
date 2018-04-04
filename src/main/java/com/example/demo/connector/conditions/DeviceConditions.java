package com.example.demo.connector.conditions;

import com.example.demo.enums.DeviceTypeEnum;
import org.springframework.data.domain.Sort;

/**
 * @author yang
 * @create_at 17-10-24
 **/
public class DeviceConditions extends SearchConditions{
    private String deviceName;
    private String deviceCategory;
    private String deviceCode;
    private String deviceClass;
    private String deviceKind;
    private Sort sort;
    private boolean processing=true;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceCategory() {
        return deviceCategory;
    }

    public void setDeviceCategory(String deviceCategory) {
        this.deviceCategory = deviceCategory;
    }



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


    @Override
    public void setOrderBy(int orderBy) {
        super.setOrderBy(orderBy);
        switch (orderBy){
            case 1:
                sort = new Sort(Sort.Direction.ASC, "deviceType");
                break;
            case 2:
                sort=new Sort(Sort.Direction.ASC, "createAt");
                break;
            case 3:
                sort=new Sort(Sort.Direction.ASC, "updateAt");
                break;
            default:
                sort=null;
        }
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public Sort getSort() {
        return sort;
    }


    public boolean isProcessing() {
        return processing;
    }

    public void setProcessing(boolean processing) {
        this.processing = processing;
    }
}
