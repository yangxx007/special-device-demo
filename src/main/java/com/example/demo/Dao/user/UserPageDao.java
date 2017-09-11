package com.example.demo.Dao.user;

import com.example.demo.entity.userModel.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;



/**
 * Created by yang on 2017/7/26.
 */
public interface UserPageDao extends PagingAndSortingRepository<UserInfo,Integer> {
//    public UserInfo findByUsername(String username);
//    public UserInfo findByUid(int id);
//    public UserInfo findByUidOrUsername(long id, String username);
//    @Transactional
//    public Integer deleteUserInfoByUsernameOrUid(String username, long id);
//    public List<UserInfo> findAllByUidNotNullOrderByUid();
//    //对于申请可以是findAllByUidNotNullOrderByCreateTime();
    Page<UserInfo> findByUidNotNull(Pageable pageable);
}
