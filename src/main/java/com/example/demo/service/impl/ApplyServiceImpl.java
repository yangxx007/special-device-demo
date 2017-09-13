package com.example.demo.service.impl;

import com.example.demo.Dao.apply.ApplyInfoDao;
import com.example.demo.entity.dataModel.ApplyInfo;
import com.example.demo.entity.dataModel.ApplyStatus;
import com.example.demo.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yang on 2017/7/26.
 */
@Service
public class ApplyServiceImpl implements ApplyService{
    @Autowired
    private ApplyInfoDao applyDao;

    @Override
    public ApplyInfo findByApplyID(Long ID) {
        return applyDao.findApplyInfoById(ID);
    }

    @Override
    public List<ApplyInfo> findApplyInfosForUser(long user_id, long device_id, long before, long after) {
        return applyDao.findAllByOwnerIdAndDeviceIdAndCreateTimeIsBetween(user_id,device_id,before,after);

    }

    @Override
    public List<ApplyStatus> findByApplierName(String username) {
        return null;
    }

    @Override
    public List<ApplyStatus> findAllApply() {
        return null;
    }

    @Override
    public void createApply(ApplyInfo apply) {
        applyDao.save(apply);
    }
}
