package com.example.demo.service.impl;

import com.example.demo.Dao.user.SysRoleDao;
import com.example.demo.entity.userModel.SysRole;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yang on 2017/9/6.
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private SysRoleDao sysRoleDao;
    @Override
    public List<SysRole> createUserAccount() {
       return sysRoleDao.findById(1);

    }

    @Override
    public List<SysRole> createAdminAccount() {
       return sysRoleDao.findById(5);
    }

    @Override
    public List<SysRole> createApproverAccount() {

        return sysRoleDao.findById(2);
    }

    @Override
    public List<SysRole> createAcceptorAccount() {

        return sysRoleDao.findById(3);
    }

    @Override
    public List<SysRole> createSupervisorAccount() {

        return sysRoleDao.findById(4);
    }

}
