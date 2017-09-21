package com.example.demo.service;

import com.example.demo.entity.userModel.SysPermission;
import com.example.demo.entity.userModel.SysRole;
import com.example.demo.entity.userModel.UserInfo;
import org.apache.shiro.subject.Subject;

import java.util.List;

/**
 * Created by yang on 2017/9/12.
 */
public interface UserStatusService {

    public long getCurrUserId(Subject currSubject);

    public List<SysRole> getRoleList (Subject currSubject);

    public List<SysPermission> getPermissionList(Subject currSubject);

    public UserInfo getCurrUser(Subject currSubject);
    public String getCurrUsername(Subject subject);
}
