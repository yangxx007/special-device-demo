package com.example.demo.service.impl;

import com.example.demo.entity.userModel.SysPermission;
import com.example.demo.entity.userModel.SysRole;
import com.example.demo.entity.userModel.UserInfo;
import com.example.demo.service.ApplyService;
import com.example.demo.service.UserService;
import com.example.demo.service.UserStatusService;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yang on 2017/9/12.
 */
@Service
public class UserStatusServiceImpl implements UserStatusService {
    @Autowired
    private UserService userService;

    @Override
    public long getCurrUserId(Subject currSubject) {
        UserInfo userInfo=getCurrUser(currSubject);
        return userInfo.getUid();
    }

    @Override
    public List<SysRole> getRoleList(Subject currSubject) {
        UserInfo userInfo=getCurrUser(currSubject);
        return userInfo.getRoleList();
    }

    @Override
    public List<SysPermission> getPermissionList(Subject currSubject) {
        UserInfo userInfo=getCurrUser(currSubject);
        return userInfo.getRoleList().get(0).getPermissions();
    }

    @Override
    public UserInfo getCurrUser(Subject currSubject) {
        return userService.findByUsername((String)currSubject.getPrincipals().getPrimaryPrincipal());
    }
}
