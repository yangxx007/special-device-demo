package com.example.demo.service.impl;

import com.example.demo.Dao.apply.ApplyInfoDao;
import com.example.demo.entity.dataModel.ApplyInfo;
import com.example.demo.entity.userModel.UserInfo;
import com.example.demo.service.ApplyService;
import com.example.demo.service.UserStatusService;
import com.example.demo.service.ValidateService;
import com.example.demo.service.exception.ValidateFailException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yang on 2017/9/12.
 */
@Service
public class ValidateServiceImpl implements ValidateService {
    @Autowired
    private ApplyInfoDao applyInfoDao;
    @Autowired
    private UserStatusService userStatusService;
    @Override
    public boolean validateForm() {
        return false;
    }

    @Override
    public void isPermission(Subject subject,long applyId){
        if(applyId!=0){
            if(!isApplyOwner(subject,applyId))
                throw new ValidateFailException("你没有权限查看");
        }
        else
                throw new ValidateFailException("查看的资料非法或参数传输不正确");


    }
    public boolean isApplyOwner(Subject currSubject,long applyId) {
        try{
            UserInfo userInfo=userStatusService.getCurrUser(currSubject);

        ApplyInfo applyInfo=applyInfoDao.findApplyInfoById(applyId);
        //1. user 2. acceptor 3.approver 4.supervisor 5.admin
        switch (userInfo.getRoleList().get(0).getId())
        {
            case 1:
                return userInfo.getUid()==applyInfo.getOwnerId();

            case 2:
                return userInfo.getAgencyId()==applyInfo.getAcceptorAgencyId();

            case 3:
                return userInfo.getAgencyId()==applyInfo.getApproverAgencyId();

        }

        return true;
        }catch (NullPointerException e){
            throw new ValidateFailException("申请id错误，找不到申请");
        }
    }
    public void validateApplyOwner(Subject currSubject,long applyId) throws ValidateFailException{
        if(!isApplyOwner(currSubject,applyId)){
            throw new ValidateFailException("access apply without permission");
        }

    }
//    @Override
//    public boolean isApplyAuditor(Subject currSubject,long applyId) {
//        UserInfo userInfo=getCurrUser(currSubject);
//        ApplyInfo applyInfo=applyService.findByApplyID(applyId);
//        return userInfo.getUid()==applyInfo.getAuditor_adminstration_id();
//    }
//
//    @Override
//    public boolean isApplyAcceptor(Subject currSubject, long apply_id) {
//        UserInfo userInfo=getCurrUser(currSubject);
//        ApplyInfo applyInfo=applyService.findByApplyID(apply_id);
//        return userInfo.getUid()==applyInfo.getAcceptor_adminstration_id();
//    }

}
