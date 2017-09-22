package com.example.demo.service.impl;

import com.example.demo.Dao.apply.ApplyInfoDao;
import com.example.demo.Dao.apply.ApplyInfoSpecification;
import com.example.demo.entity.dataModel.ApplyInfo;
import com.example.demo.entity.dataModel.ApplyStatus;
import com.example.demo.entity.formModel.Form1;
import com.example.demo.service.ApplyService;
import com.example.demo.service.ValidateService;
import com.example.demo.service.exception.NotFoundException;
import com.example.demo.service.exception.ValidateFailException;
import com.example.demo.service.exception.VerifyFailException;
import com.example.demo.service.staticfunction.VerifyUtil;
import jdk.nashorn.internal.codegen.ApplySpecialization;
import org.apache.shiro.subject.Subject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import javax.persistence.criteria.*;
import java.lang.reflect.Field;
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
    public ApplyInfo findByApplyID(Long ID,Subject subject) throws NotFoundException {
        ApplyInfo applyInfo=applyDao.findApplyInfoById(ID);
        validateService.isPermission(subject,ID);
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
    public void createApply(ApplyInfo apply,long userId) {
        apply.setId(0);
        apply.setOwnerId(userId);
        applyDao.save(apply);
    }

    @Override
    public Page<ApplyInfo> searchForUser(long userId,long deviceTypeId,long start,long end,Pageable pageable) {
        return applyDao.findAll(ApplyInfoSpecification.mixSearchApply(ApplyInfoSpecification.USER,userId,deviceTypeId,
                start,end),pageable);

    }
    @Override
    public Page<ApplyInfo> searchForApprover(long userId,long deviceTypeId,long start,long end,Pageable pageable) {
        return applyDao.findAll(ApplyInfoSpecification.mixSearchApply(ApplyInfoSpecification.APPROVER,userId,deviceTypeId,
                start,end),pageable);

    }
    @Override
    public Page<ApplyInfo> searchForAcceptor(long userId,long deviceTypeId,long start,long end,Pageable pageable) {
        return applyDao.findAll(ApplyInfoSpecification.mixSearchApply(ApplyInfoSpecification.ACCEPTOR,userId,
                deviceTypeId,start,end),pageable);

    }

    @Override
    public ApplyStatus findApplyStatusByApplyId(long apply_id) {
        return applyDao.findApplyStatusByapplyInfoId(apply_id);
    }

    @Override
    public void delApply(long applyId,Subject subject) {
        applyDao.delete(findByApplyID(applyId,subject));
    }

    @Override
    public void saveApply(ApplyInfo applyInfo, Subject subject) {
        validateService.isPermission(subject,applyInfo.getId());
        applyDao.save(applyInfo);
    }

    @Override
    public void confirmApply(long applyId, Subject subject)  {
        ApplyInfo applyInfo=findByApplyID(applyId,subject);
        VerifyUtil.verifyApply(null,applyInfo);
        //System.out.println(applyInfo.getClass().getDeclaredFields()[1].getName());

    }


}
