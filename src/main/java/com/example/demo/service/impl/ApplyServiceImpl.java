package com.example.demo.service.impl;

import com.example.demo.Dao.apply.ApplyInfoDao;
import com.example.demo.Dao.apply.ApplyInfoSpecification;
import com.example.demo.entity.dataModel.ApplyInfo;
import com.example.demo.entity.dataModel.ApplyStatus;
import com.example.demo.service.ApplyService;
import com.example.demo.service.ValidateService;
import com.example.demo.service.exception.NotFoundException;
import com.example.demo.service.exception.ValidateFailException;
import jdk.nashorn.internal.codegen.ApplySpecialization;
import org.apache.shiro.subject.Subject;
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
    @Autowired
    private ValidateService validateService;

    @Override
    public ApplyInfo findByApplyID(Long ID) throws NotFoundException {
        ApplyInfo applyInfo=applyDao.findApplyInfoById(ID);
        if(applyInfo==null)
            throw  new NotFoundException("找不到申请");
        return applyInfo;
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
        apply.setId(0);
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
    public void saveApply(ApplyInfo applyInfo, Subject subject) {
        if(applyInfo.getId()!=0)
            if(subject!=null)
                validateService.isApplyOwner(subject,applyInfo.getId());
            else
                throw new ValidateFailException("还没登录验证");
        else
            throw new ValidateFailException("没有传送applyId");
        applyDao.save(applyInfo);
    }


}
