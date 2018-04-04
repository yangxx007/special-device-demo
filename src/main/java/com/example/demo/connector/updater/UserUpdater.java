package com.example.demo.connector.updater;

import com.example.demo.entity.user.UserData;
import com.example.demo.entity.user.UserInfo;
import com.example.demo.service.exception.VerifyFailException;
import com.example.demo.service.utils.UtilServiceImpl;
import com.example.demo.service.utils.VerifyUtil;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @Author yang
 * @CREATE_AT 17-10-18
 **/
public class UserUpdater {
    private UserData userData;
    private String password;
    public  void update(UserInfo userInfo)
    {
        if(password!=null){
            userInfo.setPassword(UtilServiceImpl.encryptPWD(password, userInfo.getSalt()));
        }
        if(userData!=null){
            userInfo.setUserData(userData);
        }

    }
    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(!VerifyUtil.verify(password,VerifyUtil.PASSWORD)){
            throw new VerifyFailException("密码格式不正确");}
        this.password = password;
    }
}
