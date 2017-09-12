package com.example.demo.web;


import com.example.demo.entity.userModel.UserInfo;
import com.example.demo.service.UserService;
import com.example.demo.service.UserStatusService;
import com.example.demo.service.ValidateService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.util.Collection;
import java.util.Map;

/**
 * Created by yang on 2017/8/10.
 */
@Controller
public class HomeController {

    @Autowired
    UserStatusService userStatusService;

    @RequestMapping({"/", "/index"})
    public String index() {
        return "/index";
    }

    @RequestMapping("/logout")
    public boolean logout() {
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
        } catch (Exception e) {
            return false;
        }
        return true;

    }

//    @RequestMapping("/login")
//    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {
//        System.out.println("HomeController.login()");
//        // 登录失败从request中获取shiro处理的异常信息。
//        // shiroLoginFailure:就是shiro异常类的全类名.
//        String exception = (String) request.getAttribute("shiroLoginFailure");
//        System.out.println("exception=" + exception);
//        String msg = "";
//        if (exception != null) {
//            if (UnknownAccountException.class.getName().equals(exception)) {
//                System.out.println("UnknownAccountException -- > 账号不存在：");
//                msg = "UnknownAccountException -- > 账号不存在：";
//            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
//                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
//                msg = "IncorrectCredentialsException -- > 密码不正确：";
//            } else if ("kaptchaValidateFailed".equals(exception)) {
//                System.out.println("kaptchaValidateFailed -- > 验证码错误");
//                msg = "kaptchaValidateFailed -- > 验证码错误";
//            } else {
//                msg = "else >> " + exception;
//                System.out.println("else -- >" + exception);
//            }
//        }
//        map.put("msg", msg);
//        // 此方法不处理登录成功,由shiro进行处理
//        return "/login";
//    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    String adminlogin(HttpServletRequest request) throws Exception {
        JSONObject json = new JSONObject();
        String msg=null;
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("password"));
        UsernamePasswordToken uptoken = new UsernamePasswordToken(request.getParameter("username"), request.getParameter
                ("password"));
        Subject currentuser = SecurityUtils.getSubject();
        try{
            currentuser.login(uptoken);
        }
        catch (UnknownAccountException e)
        {
            System.out.println("UnknownAccountException -- > 账号不存在：");
            msg = "UnknownAccountException -- > 账号不存在：";
        }
        catch (IncorrectCredentialsException e) {
            System.out.println("IncorrectCredentialsException -- > 密码不正确：");
            msg = "IncorrectCredentialsException -- > 密码不正确：";
        }
//        catch () {
//            System.out.println("kaptchaValidateFailed -- > 验证码错误");
//            msg = "kaptchaValidateFailed -- > 验证码错误";
//        }
        catch(Exception e) {
            msg = "else >> " + e;
            System.out.println("else -- >" + e);
        };




        if (currentuser.isAuthenticated()) {
            json.append("status", "true");
            //这里要把获取角色的方法要放到service里
            json.append("role", userStatusService.getRoleList(currentuser).get(0).getId().toString());
            return json.toString();
        } else {
            json.append("status", "false");
            json.append("msg",msg);
        }
        System.out.println(json.toString());
        return json.toString();

    }


    @RequestMapping("/403")
    public String unauthorizedRole() {
        System.out.println("------没有权限-------");
        return "403";
    }
}