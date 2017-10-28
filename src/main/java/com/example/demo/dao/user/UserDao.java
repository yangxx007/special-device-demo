package com.example.demo.dao.user;

import com.example.demo.entity.user.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Created by yang on 2017/7/26.
 */
//这里是连接数据库的操作的类函数，因为用的jpa所以不需要像mybaits一样写sql语句，直接按提示写好借口就行，如果返回量大有分页要求，查看userpageDao文件

public interface UserDao extends JpaRepository<UserInfo,Integer> {
    public UserInfo findByUsername (String username);
    public UserInfo findByUid(int id);
    public UserInfo findByUidOrUsername(long id,String username);
    public Integer deleteUserInfoByUsernameOrUid(String username, long id);
    public List<UserInfo> findAllByUidNotNullOrderByUid();
    //public List<UserInfo> findAllBySex(UserSexEnum sex);
    //List<UserInfo> findAllIgnoreRoleList();
    //对于申请可以是findAllByUidNotNullOrderByCreateTime();
}
