package com.example.demo.service.impl;

import com.example.demo.Dao.user.UserPageDao;
import com.example.demo.entity.userModel.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.Dao.user.UserDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.service.UserService;


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

    @Override
    public UserInfo findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public UserInfo createUser(UserInfo userInfo) {
        return userDao.save(userInfo);
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

}
