package com.example.demo.web;

import com.example.demo.entity.dataModel.ApplyInfo;
import com.example.demo.entity.dataModel.ApplyStatus;
import com.example.demo.entity.userModel.UserInfo;
import com.example.demo.service.*;
import com.example.demo.service.exception.KaptchaFailException;
import com.example.demo.service.staticfunction.UtilServiceImpl;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by yang on 2017/7/26.
 */
//controller标识这个程序是controller
@Controller
//requestMapping 标识url路径如http://***.com/admin
@RequestMapping("/admin")
//requirespermissions 标识当前用户需要怎样的权限才能访问这个url
//@RequiresPermissions(value ={"admin:view","admin:edit","admin:del"},logical = Logical.AND)
public class AdminController {
    //autowired 标识这个变量是一个接口变量，并且会自动在标识有service的实现类中自动继承
    @Autowired
    private UserService userSevice;

    @RequestMapping(value = "/user/all", method = RequestMethod.GET)
    //responsebody标识是直接返回字符串，没有标识返回对应名字的html
    public @ResponseBody
    List<UserInfo> getUserList() {
        return userSevice.findAll();
    }

    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public @ResponseBody
    UserInfo getUserByUsername(@PathVariable("username") String username) {
        System.out.print(username);
        return userSevice.findByUsername(username);
    }

    //requstparam是从get方法中获取相应的key的value值
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public @ResponseBody
    UserInfo getUserByUidandUsername(@RequestParam(name = "username", required = false) String username,
                                     @RequestParam(name = "uid", defaultValue = "0", required = false) Long uid) {

        return userSevice.findByUidOrUsername(uid, username);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public @ResponseBody
    Integer deleteUserByUidandUsername(@RequestParam(name = "username", required = false) String username,
                                       @RequestParam(name = "uid", defaultValue = "0", required = false) Long uid) {

        return userSevice.deleteUserByUsernameOrUid(username, uid);
    }

    //requestbody标识是指请求体，如果请求体是json数据直接就将其赋给userinfo或其他类如下，直接就可以转化为类了
    @RequestMapping(value = "/userlist", method = RequestMethod.PUT)
    public @ResponseBody
    boolean createUserList(@RequestBody List<UserInfo> userInfos) {
        try {
            userSevice.createUserList(userInfos);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public @ResponseBody
    boolean updateUser(@RequestBody UserInfo userInfo) {
        try {
            userSevice.updateUser(userInfo);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @RequestMapping(value = "/user/page", method = RequestMethod.GET)
    public @ResponseBody
    Page<UserInfo> getUserByUidandUsernameInpage(@RequestParam(name = "page", defaultValue = "0") Integer
                                                         page,
                                                 @RequestParam(name = "size", defaultValue = "0") Integer size) {
        Sort sort = new Sort(Sort.Direction.ASC, "uid");
        Pageable pageable = new PageRequest(page, size, sort);
        return userSevice.findAllInPage(pageable);

    }



    //@RequestMapping(value = "/user/page",method = RequestMethod.GET)
//public String createUser(HttpServletRequest request){
//    UserInfo userInfo;
//
//    userInfo.setName(request.getAttribute("name").toString());
//    userInfo.setPassword(request.getAttribute("password").toString());
//    userInfo.setState(request.getAttribute("state").toString().getBytes()[0]);
//    userInfo.setUsername(request.getAttribute("username").toString());
//    try {
//        userSevice.createUser(userInfo);
//    } catch (Exception e) {
//        return "403";
//    }
//    return "index";
//}
    @RequestMapping("/logout")
    public @ResponseBody
    String logout() {
        SecurityUtils.getSubject().logout();
        return "0";
    }



//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public @ResponseBody
//    String adminlogin(HttpServletRequest request) {
//        JSONObject json = new JSONObject();
//        String msg = null;
//        System.out.println(request.getParameter("username"));
//        System.out.println(request.getParameter("password"));
//        System.out.println(request.getParameter("verifycode"));
//        UsernamePasswordToken uptoken = new UsernamePasswordToken(request.getParameter("username"), request.getParameter
//                ("password"));
//        Subject currentuser = SecurityUtils.getSubject();
//        try {
//            kaptchaService.KaptchaValidate(currentuser, request.getParameter("verifycode"));
//            currentuser.login(uptoken);
//        } catch (UnknownAccountException e) {
//            System.out.println("UnknownAccountException -- > 账号不存在：");
//            msg = "账号不存在";
//        } catch (IncorrectCredentialsException e) {
//            System.out.println("IncorrectCredentialsException -- > 密码不正确：");
//            msg = "密码不正确";
//        } catch (KaptchaFailException e) {
//            System.out.println("kaptchaFailedException -- > " + e.getMsgDes());
//            msg = e.getMsgDes();
//        } catch (Exception e) {
//            msg = "else >> " + e;
//            System.out.println("else -- >" + e);
//        }
//        ;
//        if (currentuser.isAuthenticated()) {
//            json.append("status", "true");
//            //这里要把获取角色的方法要放到service里
//            json.append("role", userStatusService.getRoleList(currentuser).get(0).getId().toString());
//            return json.toString();
//        } else {
//            json.append("status", "false");
//            json.append("msg", msg);
//        }
//        System.out.println(json.toString());
//        return json.toString();
//    }


//@RequestMapping(value = "/login",method = RequestMethod.POST)
//@ResponseBody public   String adminlogin(HttpServletRequest request) throws  Exception
//{
//
////    BufferedReader reader=servletRequest.getReader();
////    String str, wholeStr = "";
////    while((str = reader.readLine()) != null){
////        wholeStr += str;
////    }
////    System.out.println(wholeStr);
////    System.out.println(servletRequest.getParameterNames().nextElement().toString());
//    //System.out.println(adminlogin2(servletRequest));
//    System.out.println(request.getParameter("username"));
//    System.out.println(request.getParameter("password"));
//    System.out.println(request.getParameter("verifycode"));
//
//    UsernamePasswordToken uptoken=new UsernamePasswordToken(request.getParameter("username"),request.getParameter
//            ("password"));
//    Subject currentuser= SecurityUtils.getSubject();
//    currentuser.login(uptoken);
//    JSONObject json=new JSONObject();
//
//    if (currentuser.isAuthenticated()) {
//        json.append("status","true");
//        UserInfo userInfo2 = userSevice.findByUsername((String)currentuser.getPrincipals().getPrimaryPrincipal
//                ());
//        //这里要把获取角色的方法要放到service里
//        json.append("role",userInfo2.getRoleList().get(0).getId().toString());
//        return json.toString();
//    }
//    else
//        json.append("status","false");
//    System.out.println(json.toString());
//    return json.toString();
//}
//    @RequestMapping(value = "/login2",method = RequestMethod.POST)
//    @ResponseBody
//    public   String adminlogin2(HttpServletRequest servletRequest) throws  Exception
//    {   //String username=servletRequest.getParameter("username");
//
//        BufferedReader reader=servletRequest.getReader();
//        String str, wholeStr = "";
//        while((str = reader.readLine()) != null){
//            wholeStr += str;
//        }
//        System.out.println(wholeStr);
//
//        return "wholestr:"+ wholeStr;
//
//    }



    @RequestMapping("/usertest")
    public @ResponseBody
    List<UserInfo> getUsers(@RequestParam(name = "name") String name, @RequestParam(name = "start")
            JSONArray json) {
        return userSevice.finduserfortest(name, json.getLong(0), json.getLong(1));
    }

//    @RequestMapping("/applylist")
//    public @ResponseBody
//    Page<ApplyInfo> getApplyList(HttpServletRequest request) {
//        int page=0,size=1,device_id=0;
//        long start = 0;
//        long end = UtilServiceImpl.date2Long(new Date());
//        String format = "yyyy-MM-dd";
//
//        try {
//            page=Integer.parseInt(request.getParameter("page"));
//            size=Integer.parseInt(request.getParameter("size"));
//            device_id=Integer.parseInt(request.getParameter("device_id"));
//            JSONArray json= new JSONArray(request.getParameter("time"));
//            start = UtilServiceImpl.string2Long(json.getString(0), format);
//            //end要加一天的时间
//            end = UtilServiceImpl.string2Long(json.getString(1), format)+86400000;
//
//        } catch (ParseException e) {
//            System.out.println("筛选条件输入错误");
//        }catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
////        System.out.println(start);
////        System.out.println(end);
////        return applyService.findApplyInfosForUser(1,
////                device_id, start, end, pageable);
//        Sort sort = new Sort(Sort.Direction.ASC, "id");
//        Pageable pageable = new PageRequest(page, size, sort);
//        Page<ApplyInfo> applyInfos=applyService.findstream(device_id,start,end,pageable);
////        System.out.println(new JSONObject(applyInfos).get("sort").toString());
////        List<ApplyInfo> applyInfoList=(List<ApplyInfo>) new JSONObject(applyInfos).get("content");
////        JSONObject applyObject=new JSONObject();
////        int i=0;
////        for(ApplyInfo apply: applyInfoList) {
////            System.out.println(apply.getId());
////            ApplyStatus applyStatus=applyService.findApplyStatusByApplyId(apply.getId());
////            applyObject.append(i+"",(new JSONObject(apply)).toString()+(new JSONObject(applyStatus)).toString());
////            i++;
////        }
////        return applyInfos;
//        return applyInfos;
////        return applyService.findApplyInfosForUser(userStatusService.getCurrUserId(SecurityUtils.getSubject()),
////                device_id,start,end);
//    }



}
