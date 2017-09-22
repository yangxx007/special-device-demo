package com.example.demo.service;

import com.example.demo.entity.userModel.SysPermission;
import com.example.demo.entity.userModel.SysRole;
import com.example.demo.entity.userModel.UserInfo;
import org.apache.shiro.subject.Subject;

import java.util.List;


/**
 * Created by yang on 2017/7/27.
 */
public interface ValidateService {

    public boolean validateForm ();


    public boolean isApplyOwner(Subject currSubject,long apply_id);

//    public boolean isApplyAuditor (Subject currSubject,long apply_id);
//
//    public boolean isApplyAcceptor(Subject currSubject,long apply_id);
}
