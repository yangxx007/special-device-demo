package com.example.demo.Dao.user;

import com.example.demo.entity.userModel.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by yang on 2017/9/6.
 */
public interface  SysRoleDao extends JpaRepository<SysRole,Long>{
    public List<SysRole> findById(int id);
}
