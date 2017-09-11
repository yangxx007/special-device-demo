package com.example.demo.service;

import com.example.demo.entity.userModel.SysRole;

import java.util.List;


/**
 * Created by yang on 2017/9/6.
 */
public interface AccountService {
    public List<SysRole> createUserAccount();

    public List<SysRole> createAdminAccount();
    public List<SysRole> createApproverAccount();
    public List<SysRole> createAcceptorAccount();

    public List<SysRole> createSupervisorAccount();
}
