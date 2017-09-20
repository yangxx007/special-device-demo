package com.example.demo.service.impl;

import com.example.demo.entity.dataModel.ApplyInfo;
import com.example.demo.entity.userModel.UserInfo;
import com.example.demo.service.ApplyService;
import com.example.demo.service.UserStatusService;
import com.example.demo.service.ValidateService;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yang on 2017/9/12.
 */
@Service
public class ValidateServiceImpl implements ValidateService {
    @Autowired
    private ApplyService applyService;
    @Autowired
    private UserStatusService userStatusService;
    @Override
    public boolean validateForm() {
        return false;
    }

    @Override
    public boolean isApplyOwner(Subject currSubject,long applyId) {
        UserInfo userInfo=userStatusService.getCurrUser(currSubject);
        ApplyInfo applyInfo=applyService.findByApplyID(applyId);
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

        return false;
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
