package com.example.demo.service.impl;

import com.example.demo.dao.user.SysRoleDao;
import com.example.demo.entity.user.SysRole;
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
    //1.普通用户。 2.受理人员  3.审批人员   4.监管人员   5.超级用户
    @Override
    public List<SysRole> createUserAccount(int level) {
       switch(level){
           case 1:
               return sysRoleDao.findById(1);
           case 2:
               return sysRoleDao.findById(2);
           case 3:
               return sysRoleDao.findById(3);
           case 4:
               return sysRoleDao.findById(4);
           case 5:
               return sysRoleDao.findById(5);
           default:
               return null;
       }


    }


}
