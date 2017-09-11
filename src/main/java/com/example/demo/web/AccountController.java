package com.example.demo.web;

import com.example.demo.entity.userModel.UserInfo;
import com.example.demo.service.UserService;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yang on 2017/9/6.
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    private UserService userService;
    @RequestMapping("/createuser")
    public String createUser(@RequestBody UserInfo userInfo)
    {
        JSONObject jo=new JSONObject();

        try{userService.createUser(userInfo);
            SimpleDateFormat timeformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            userInfo.setCreateAt(Timestamp.valueOf(timeformat.format(new Date())));}
        catch(Exception e)
        {jo.append("status","false");
        return jo.toString();}
        jo.append("status","true");
        return jo.toString();

    }
//    @RequestMapping("/createuser")
//    public String createUser(@RequestBody UserInfo userInfo)
//    {
//
//  }


}
