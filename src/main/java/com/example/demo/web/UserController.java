package com.example.demo.web;

import com.example.demo.entity.user.UserData;
import com.example.demo.enums.JsonResponse;
import com.example.demo.service.UserStatusService;
import org.apache.shiro.SecurityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yang
 * @create_at 2017/10/17
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserStatusService userStatusService;
    @RequestMapping(value = "/inform",method = RequestMethod.GET)
    public @ResponseBody
    JsonResponse getUserInform(){
        UserData userData=userStatusService.getCurrUser(SecurityUtils.getSubject().getSession()).getUserData();
        System.out.println(new JSONObject(userData).toString());
        return new JsonResponse(200,null,userData);
    }
}
