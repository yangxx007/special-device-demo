package com.example.demo.service;


import com.example.demo.entity.user.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
/**
 * @author yang
 * @create_at 2017/10/17
 **/
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
