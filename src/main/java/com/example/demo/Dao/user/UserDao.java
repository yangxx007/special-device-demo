package com.example.demo.Dao.user;

import com.example.demo.entity.userModel.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


/**
 * Created by yang on 2017/7/26.
 */
//这里是连接数据库的操作的类函数，因为用的事jpa所以不需要像mybaits一样写sql语句，直接按提示写好借口就行，如果返回量大有分页要求，查看userpageDao文件

public interface UserDao extends JpaRepository<UserInfo,Integer> {
    public UserInfo findByUsername (String username);
    public UserInfo findByUid(int id);
    public UserInfo findByUidOrUsername(long id,String username);
    @Transactional
    public Integer deleteUserInfoByUsernameOrUid(String username, long id);
    public List<UserInfo> findAllByUidNotNullOrderByUid();
    @Query("select u from UserInfo u")
    List<UserInfo> findAllIgnoreRoleList();
    //对于申请可以是findAllByUidNotNullOrderByCreateTime();
}
