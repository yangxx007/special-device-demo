package com.example.demo.responseModel;

import com.example.demo.entity.dataModel.ApplyInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;



public class ApplyResponse {
    @JsonIgnore
    private ApplyInfo applyInfo;

    private String applyTypeName;
    //other String or String[] Variable that front needed
    public ApplyResponse(ApplyInfo applyInfo) {

    }
}
