package com.example.demo.service;

import com.example.demo.entity.userModel.SysPermission;
import com.example.demo.entity.userModel.SysRole;
import com.example.demo.entity.userModel.UserInfo;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import java.util.List;

/**
 * Created by yang on 2017/9/12.
 */
public interface UserStatusService {

    public long getCurrUserId(Session session);

    public List<SysRole> getRoleList (Session session);

    public List<SysPermission> getPermissionList(Session session);

    public UserInfo getCurrUser(Session session);
    public String getCurrUsername(Session session);
}
