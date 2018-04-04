package com.example.demo.web;


import com.example.demo.entity.user.UserInfo;
import com.example.demo.enums.JsonResponse;
import com.example.demo.service.KaptchaService;
import com.example.demo.service.UserStatusService;
import org.apache.shiro.SecurityUtils;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yang
 * @create_at 2017/10/17
 **/
@Controller
public class HomeController {

    @Autowired
    UserStatusService userStatusService;
    @Autowired
    KaptchaService kaptchaService;

//    @RequestMapping({"/", "/index"})
//    public String index() {
//        return "/index";
//    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public @ResponseBody JsonResponse logout() throws Exception{

        SecurityUtils.getSubject().logout();

        return new JsonResponse();

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
    JsonResponse adminlogin(@RequestParam("username") String username, @RequestParam("password") String password,
                            @RequestParam("verifycode") String vertifycode, HttpServletRequest request) throws Exception {
        JsonResponse jsonResponse = new JsonResponse();
        Map<String, Object> data = new HashMap<>();
        Subject currentuser = SecurityUtils.getSubject();
        if (currentuser.isAuthenticated()) {
            jsonResponse.setStatus(200);
            //这里要把获取角色的方法要放到service里
            UserInfo userInfo = userStatusService.getCurrUser(currentuser.getSession());
            data.put("username", userInfo.getUsername());
            data.put("role", userInfo.getRoleList().get(0).getId());
            jsonResponse.setData(data);
            return jsonResponse;
        } else {
            UsernamePasswordToken uptoken = new UsernamePasswordToken(username, password);
            kaptchaService.KaptchaValidate(currentuser, vertifycode);
            currentuser.login(uptoken);
            return adminlogin(username,password,vertifycode,request);
        }

    }


    @RequestMapping("/403")
    public String unauthorizedRole() {
        System.out.println("------没有权限-------");
        return "403";
    }
}