package com.example.demo.service.impl;

import com.example.demo.service.UtilService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

/**
 * Created by yang on 2017/9/12.
 */
@Service
public class UtilServiceImpl implements UtilService {
    @Override
    public String encryptPWD(String password,String credential) {
        Md5Hash md5Hash=new Md5Hash(password,credential,2);
        return md5Hash.toString();
    }
}
