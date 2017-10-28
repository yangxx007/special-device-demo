package com.example.demo.connector.updater;

import com.example.demo.entity.user.UserData;
import com.example.demo.entity.user.UserInfo;
import com.example.demo.service.staticfunction.UtilServiceImpl;

/**
 * @Author yang
 * @CREATE_AT 17-10-18
 **/
public class UserUpdater {
    private UserData userData;
    private String password;
    public  UserInfo update(UserInfo userInfo)
    {
     userInfo.setPassword(UtilServiceImpl.encryptPWD(password,userInfo.getSalt()));
     userInfo.setUserData(userData);
     return userInfo;
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
        this.password = password;
    }
}
