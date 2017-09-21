package com.example.demo.service;


import com.example.demo.entity.userModel.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by yang on 2017/7/26.
 */
public interface UserService {
    public UserInfo findByUsername(String username);
    public void createUser(UserInfo userInfo,int level);
    public UserInfo findByUidOrUsername(long id,String username);
    public Integer  deleteUserByUsernameOrUid(String username,long uid);
    public UserInfo updateUser(UserInfo userInfo);
    public List<UserInfo> findAll();
    public Page<UserInfo> findAllInPage(Pageable pageable);
    public List<UserInfo> createUserList(List<UserInfo> userInfos);
    public List<UserInfo> finduserfortest(String name, long start,long end);

}
