package com.example.demo.service;


import com.example.demo.entity.user.UserInfo;
import org.apache.shiro.session.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author yang
 * @create_at 2017/10/17
 **/
public interface UserService {
    UserInfo findByUsername(String username);

    void createUser(UserInfo userInfo, int level);

    UserInfo findByUidOrUsername(long id, String username);

    Integer deleteUserByUsernameOrUid(String username, long uid);

    UserInfo updateUser(UserInfo userInfo);

    List<UserInfo> findAll();

    Page<UserInfo> findAllInPage(Pageable pageable);

    List<UserInfo> createUserList(List<UserInfo> userInfos);

    List<UserInfo> finduserfortest(String name, long start, long end);

    UserInfo updateUser(UserInfo userInfo, Session session);
}
