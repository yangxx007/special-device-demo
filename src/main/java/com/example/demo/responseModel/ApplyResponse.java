package com.example.demo.responseModel;

import com.example.demo.entity.dataModel.ApplyInfo;
import com.example.demo.entity.dataModel.ApplyStatus;
import com.example.demo.enums.DeviceTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplyResponse extends ApplyInfo{

    private int deviceTypeId;
    public ApplyResponse(ApplyInfo applyInfo){
        super.setStatus(applyInfo.getStatus());
        super.setAcceptorAgencyId(applyInfo.getAcceptorAgencyId());
        super.setAcceptorAgencyName(applyInfo.getAcceptorAgencyName());
        super.setAddressId(applyInfo.getAddressId());
        super.setAddressName(applyInfo.getAddressName());
        super.setDeviceType(applyInfo.getDeviceType());
        setDeviceTypeId(applyInfo.getDeviceType().ordinal());
        super.setApplyType(applyInfo.getApplyType());
	super.setId(applyInfo.getId());
    }
    public int getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(int deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }
}
