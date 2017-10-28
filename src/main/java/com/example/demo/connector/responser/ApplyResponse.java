package com.example.demo.connector.responser;

import com.example.demo.entity.data.ApplyInfo;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplyResponse extends ApplyInfo{




    private int deviceTypeId;
    public ApplyResponse(ApplyInfo applyInfo){
        super.setStatus(applyInfo.getStatus());
        super.setAcceptorAgencyId(applyInfo.getAcceptorAgencyId());
        super.setAcceptorAgencyName(applyInfo.getAcceptorAgencyName());
        super.setDeviceType(applyInfo.getDeviceType());
        setDeviceTypeId(applyInfo.getDeviceType().ordinal());
        super.setApplyType(applyInfo.getApplyType());
        super.setId(applyInfo.getId());
        super.setDeviceCategory(applyInfo.getDeviceCategory());
        super.setDeviceClass(applyInfo.getDeviceClass());
        super.setDeviceCode(applyInfo.getDeviceCode());
        super.setDeviceKind(applyInfo.getDeviceKind());
        super.setDeviceName(applyInfo.getDeviceName());
        super.setCreateTime(applyInfo.getCreateTime());
    }
    public int getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(int deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }
}
