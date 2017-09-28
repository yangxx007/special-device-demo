package com.example.demo.enums;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.UsersDocument;

import java.io.Serializable;

/**
 * Created by yang on 2017/7/26.
 */
public enum UserSexEnum {
    男(1), 女(2);

    public int getName() {
        return name;
    }

    private int name;
    UserSexEnum(int name){
     this.name=name;
    }





}
