package com.example.demo.service;

import com.example.demo.entity.dataModel.ApplyInfo;

import com.example.demo.entity.dataModel.ApplyStatus;

import java.util.List;

/**
 * Created by yang on 2017/7/27.
 */
public interface ApplyService {
    public ApplyInfo findByApplyID(Long ID);
    public List<ApplyStatus> findByApplierName(String username);
    public List<ApplyStatus> findAllApply();
    public void createApply(ApplyStatus apply);
}
