package com.example.demo.responseModel;

import com.example.demo.entity.dataModel.ApplyInfo;
import com.example.demo.entity.dataModel.ApplyStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplyResponse extends ApplyInfo{
    @JsonIgnore
    private long id;

    public ApplyResponse(ApplyInfo applyInfo){
        super.setStatus(applyInfo.getStatus());
        super.setAcceptorAgencyId(applyInfo.getAcceptorAgencyId());
        super.setAcceptorAgencyName(applyInfo.getAcceptorAgencyName());
        super.setAddressId(applyInfo.getAddressId());
        super.setAddressName(applyInfo.getAddressName());
        super.setDeviceType(applyInfo.getDeviceType());
        super.setApplyType(applyInfo.getApplyType());
    }

}
