package com.example.demo.service;

import com.example.demo.entity.user.SysRole;

import java.util.List;

/**
 * @author yang
 * @create_at 2017/10/17
 **/
public interface AccountService {
    public List<SysRole> createUserAccount(int level);
}
