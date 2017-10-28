package com.example.demo.service.impl;

import com.example.demo.dao.apply.ApplyInfoDao;
import com.example.demo.entity.data.ApplyInfo;
import com.example.demo.entity.user.UserInfo;
import com.example.demo.enums.ApplyStatesEnum;
import com.example.demo.service.UserStatusService;
import com.example.demo.service.ValidateService;
import com.example.demo.service.exception.NotFoundException;
import com.example.demo.service.exception.ValidateFailException;
import org.apache.shiro.session.Session;
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
    public void isPermission(Session session,ApplyInfo applyInfo){
        try {
            if (applyInfo.getId() != 0) {
                if (!isApplyOwner(session, applyInfo))
                    throw new ValidateFailException("你没有权限查看");
            } else
                throw new ValidateFailException("查看的资料非法或参数传输不正确");

        }catch (NullPointerException e){
            throw new NotFoundException("can not find the object that you want");
        }
    }
    public boolean isApplyOwner(Session session,ApplyInfo applyInfo) {

        UserInfo userInfo=userStatusService.getCurrUser(session);
        //1. user 2. acceptor 3.approver 4.supervisor 5.admin
        switch (userInfo.getRoleList().get(0).getId())
        {
            case 1:
                return userInfo.getUid()==applyInfo.getOwnerId();
            case 2:
                return userInfo.getAgencyId()==applyInfo.getAcceptorAgencyId();

            case 3:
                return userInfo.getAgencyId()==applyInfo.getAcceptorAgencyId();
            default:
                return true;

        }

    }
//    public void validateApplyOwner(Session session, ApplyInfo applyInfo) throws ValidateFailException{
//        if(!isApplyOwner(session,applyInfo)){
//            throw new ValidateFailException("access apply without permission");
//        }

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

//}
