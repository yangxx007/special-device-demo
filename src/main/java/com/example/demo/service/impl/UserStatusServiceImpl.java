package com.example.demo.service.impl;

import com.example.demo.Dao.user.UserDao;
import com.example.demo.entity.userModel.SysPermission;
import com.example.demo.entity.userModel.SysRole;
import com.example.demo.entity.userModel.UserInfo;
import com.example.demo.service.ApplyService;
import com.example.demo.service.RedisService;
import com.example.demo.service.UserService;
import com.example.demo.service.UserStatusService;
import com.example.demo.service.exception.ValidateFailException;
import org.apache.shiro.subject.Subject;
import org.docx4j.wml.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.Validate;

import java.util.List;

/**
 * Created by yang on 2017/9/12.
 */
@Service
public class UserStatusServiceImpl implements UserStatusService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisService redisService;
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
    public String getCurrUsername(Subject subject){
         return getCurrUser(subject).getUsername();
    }
    @Override
    public UserInfo getCurrUser(Subject currSubject) {
        try{
            //System.out.println(currSubject.getSession().getId().toString());
            String username=(String)currSubject.getPrincipals().getPrimaryPrincipal();
            //System.out.println(username);
            //String sessionId=currSubject.getSession().getId().toString();

            UserInfo userInfo=(UserInfo) redisService.find(username,RedisService.USERSTATUS);
            System.out.println(userInfo);
            if(userInfo!=null){
                System.out.println("用了缓存中的登录用户信息");
                return userInfo;
            }
            else {
                userInfo = userDao.findByUsername(username);
                redisService.save(username,RedisService.USERSTATUS,userInfo,10);
                return userInfo;
            }
        }catch (NullPointerException e){
            e.printStackTrace();
            throw new ValidateFailException("你还没有登录");
        }

    }
}
