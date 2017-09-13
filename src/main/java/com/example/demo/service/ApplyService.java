package com.example.demo.service;

import com.example.demo.entity.dataModel.ApplyInfo;
import com.example.demo.entity.dataModel.ApplyStatus;

import java.util.List;

/**
 * Created by yang on 2017/7/27.
 */
public interface ApplyService {
    public ApplyInfo findByApplyID(Long ID);
    public List<ApplyInfo> findApplyInfosForUser(long user_id, long device_id, long before,long after);
    public List<ApplyStatus> findByApplierName(String username);
    public List<ApplyStatus> findAllApply();
    public void createApply(ApplyInfo apply);
}
