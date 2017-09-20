package com.example.demo.service.impl;

import com.example.demo.Dao.apply.ApplyInfoDao;
import com.example.demo.Dao.apply.ApplyInfoSpecification;
import com.example.demo.entity.dataModel.ApplyInfo;
import com.example.demo.entity.dataModel.ApplyStatus;
import com.example.demo.service.ApplyService;
import jdk.nashorn.internal.codegen.ApplySpecialization;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.stream.Stream;

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
    public Page<ApplyInfo> findApplyInfosForUser(long user_id, long device_id, long before, long after, Pageable
            pageable) {
        return applyDao.findAllByOwnerIdAndDeviceIdAndCreateTimeIsBetween(user_id,device_id,before,after,pageable);

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





        @Override
    public Page<ApplyInfo> findstream(long id,long start,long end,Pageable pageable) {
        return applyDao.findAll(ApplyInfoSpecification.typeOfApplyInfo(id,start,end),pageable);

    }

    @Override
    public ApplyStatus findApplyStatusByApplyId(long apply_id) {
        return applyDao.findApplyStatusByapplyInfoId(apply_id);
    }

    @Override
    public void delApply(ApplyInfo applyInfo) {
        applyDao.delete(applyInfo);
    }

    @Override
    public void saveApply(ApplyInfo applyInfo) {
        applyDao.save(applyInfo);
    }
}
