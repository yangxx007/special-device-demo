package com.example.demo.service.impl;

import com.example.demo.dao.user.UserDao;
import com.example.demo.entity.user.SysPermission;
import com.example.demo.entity.user.SysRole;
import com.example.demo.entity.user.UserInfo;
import com.example.demo.service.UserStatusService;
import com.example.demo.service.exception.ValidateFailException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yang on 2017/9/12.
 */
@Service
public class UserStatusServiceImpl implements UserStatusService {
    @Autowired
    private UserDao userDao;

    @Override
    //@Cacheable(value = "userInfo",key ="'userstatusId'+#session.getId()")
    public long getCurrUserId(Session session) {
        UserInfo userInfo=getCurrUser(session);
        return userInfo.getUid();
    }

    @Override
    public List<SysRole> getRoleList(Session session) {
        UserInfo userInfo=getCurrUser(session);
        return userInfo.getRoleList();
    }

    @Override
    public List<SysPermission> getPermissionList(Session session) {
        UserInfo userInfo=getCurrUser(session);
        return userInfo.getRoleList().get(0).getPermissions();
    }
    @Override
    public String getCurrUsername(Session session){
         return getCurrUser(session).getUsername();
    }

    @Override
    //@Cacheable(value = "userInfo",key ="'userstatus'+#session.getId()")
    public UserInfo getCurrUser(Session session) {
        try{
            //System.out.println(currSubject.getSession().getId().toString());
            String username=session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY).toString();
            //System.out.println(username);
            //String sessionId=currSubject.getSession().getId().toString();
            System.out.println("用了本地保存的登录用户信息");
            UserInfo userInfo = userDao.findByUsername(username);
            return userInfo;

        }catch (NullPointerException e){
            e.printStackTrace();
            throw new ValidateFailException("你还没有登录");
        }

    }
}
