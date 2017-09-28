package com.example.demo.entity.userModel;

import com.example.demo.enums.UserSexEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class UserData implements Serializable{
    @Id@GeneratedValue
    private Integer id;
    private String name;
    private UserSexEnum sex;
}
