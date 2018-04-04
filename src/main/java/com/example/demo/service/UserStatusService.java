package com.example.demo.service;

import com.example.demo.entity.user.SysPermission;
import com.example.demo.entity.user.SysRole;
import com.example.demo.entity.user.UserInfo;
import org.apache.shiro.session.Session;

import java.util.List;
import java.util.StringTokenizer;

/**
 * @author yang
 * @create_at 2017/10/17
 **/
public interface UserStatusService {

    public long getCurrUserId(Session session);

    public List<SysRole> getRoleList (Session session);

    public List<SysPermission> getPermissionList(Session session);

    public UserInfo getCurrUser(Session session);
    public String getCurrUsername(Session session);
}
