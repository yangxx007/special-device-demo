package com.example.demo.entity.dataModel;

import com.example.demo.enums.ApplyTypeEnum;

import javax.persistence.Entity;
import javax.persistence.Id;


public class ApplyDetailType {

    private int code;
    private ApplyTypeEnum applyType;
    private String name;
    //category 1; class 2; kind 3
    private int level;
}
