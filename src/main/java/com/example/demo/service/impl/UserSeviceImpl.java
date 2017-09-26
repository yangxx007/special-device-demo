package com.example.demo.service.impl;

import com.example.demo.Dao.user.UserDao;
import com.example.demo.Dao.user.UserPageDao;
import com.example.demo.entity.userModel.UserInfo;
import com.example.demo.service.AccountService;
import com.example.demo.service.UserService;
import com.example.demo.service.exception.VerifyFailException;
import com.example.demo.service.staticfunction.UtilServiceImpl;
import com.example.demo.service.staticfunction.VerifyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * Created by yang on 2017/7/26.
 */
//service标识这是一个实现类，这样autowire标识才能够找到，并自动加载这个实现类
@Service
public class UserSeviceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserPageDao userPageDao;
    @Autowired
    private AccountService accountService;

    @Override
    public UserInfo findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public void createUser(UserInfo userInfo,int level) throws RuntimeException{
        userInfo.setUid(0);
        if(!VerifyUtil.verify(userInfo.getUsername(),VerifyUtil.USERNAME))
            throw new VerifyFailException("用户名格式不正确");
        if(!VerifyUtil.verify(userInfo.getPassword(),VerifyUtil.PASSWORD))
            throw new VerifyFailException("密码格式不正确");
        userInfo.setSalt(UtilServiceImpl.encryptPWD(UtilServiceImpl.getRandomString(), null));
        userInfo.setPassword(UtilServiceImpl.encryptPWD(userInfo.getPassword(), userInfo.getSalt()));
        userInfo.setCreatetime(UtilServiceImpl.date2Long(new Date()));
        userInfo.setRoleList(accountService.createUserAccount(level));
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findByUidOrUsername(long id, String username) {
        return userDao.findByUidOrUsername(id,username);
    }

    @Override
    public Integer deleteUserByUsernameOrUid(String username, long uid) {

          return  userDao.deleteUserInfoByUsernameOrUid(username,uid);

    }

    @Override
    public UserInfo updateUser(UserInfo userInfo) {

        return userDao.save(userInfo);
    }

    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

    @Override
    public Page<UserInfo> findAllInPage(Pageable pageable) {
        return userPageDao.findAll(pageable);
    }

    @Override
    public List<UserInfo> createUserList(List<UserInfo> userInfos) {
        return userDao.save(userInfos);
    }

    @Override
    public List<UserInfo> finduserfortest(String name, long start, long end) {
        return userPageDao.findAllByNameAndUidIsBetween(name,start,end);
    }

}
