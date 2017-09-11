package com.example.demo.web;

import com.example.demo.entity.userModel.UserInfo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.*;

import javax.servlet.http.HttpServletRequest;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


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
    @Autowired
    private AccountService accountService;

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

//    @RequestMapping(value = "/user", method = RequestMethod.PUT)
//    public @ResponseBody
//    boolean createUser(@RequestBody UserInfo userInfo) {
//        try {
//            userSevice.createUser(userInfo);
//        } catch (Exception e) {
//            return false;
//        }
//        return true;
//    }
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
        Sort sort= new Sort(Sort.Direction.ASC,"uid");
        Pageable pageable=new PageRequest(page,size,sort);
        return userSevice.findAllInPage(pageable);

    }
    @RequestMapping(value = "/createuser",method = RequestMethod.PUT)
    public @ResponseBody String createUser(@RequestBody UserInfo userInfo)
    {
        JSONObject jo=new JSONObject();

        try
        {   userSevice.createUser(userInfo);
            UserInfo userInfo2=userSevice.findByUsername(userInfo.getUsername());
            Md5Hash md5Hash=new Md5Hash(userInfo2.getPassword(),userInfo2.getCredentialsSalt(),2);
            userInfo2.setPassword(md5Hash.toString());
            SimpleDateFormat timeformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            userInfo2.setCreateAt(Timestamp.valueOf(timeformat.format(new Date())));
            userInfo2.setRoleList(accountService.createUserAccount());
            userSevice.updateUser(userInfo2);
            }
        catch(Exception e)
        {
            jo.append("status","false");
            return jo.toString();
        }
        jo.append("status","true");
        return jo.toString();

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
@RequestMapping("/test")
    public @ResponseBody String test()
{
    return "test";
}
//@RequestMapping(value = "/login",method = RequestMethod.POST)
//    public  @ResponseBody String adminlogin(@RequestBody UserInfo userInfo)
//    {
//        UsernamePasswordToken uptoken=new UsernamePasswordToken(userInfo.getUsername(),userInfo.getPassword());
//        Subject currentuser= SecurityUtils.getSubject();
//        currentuser.login(uptoken);
//        JSONObject json=new JSONObject();
//
//        if (currentuser.isAuthenticated()==true) {
//            json.append("status","true");
//            UserInfo userInfo2 =(UserInfo) currentuser.getPrincipals().getPrimaryPrincipal();
//            //这里要把获取角色的方法要放到service里
//            json.append("role",userInfo2.getRoleList().get(0).getId().toString());
//            return json.toString();
//        }
//        else
//           json.append("status","false");
//           return json.toString();
//    }

@RequestMapping(value = "/login",method = RequestMethod.POST)
@ResponseBody public   String adminlogin(HttpServletRequest request) throws  Exception
{

//    BufferedReader reader=servletRequest.getReader();
//    String str, wholeStr = "";
//    while((str = reader.readLine()) != null){
//        wholeStr += str;
//    }
//    System.out.println(wholeStr);
//    System.out.println(servletRequest.getParameterNames().nextElement().toString());
    //System.out.println(adminlogin2(servletRequest));
    System.out.println(request.getParameter("username"));
    System.out.println(request.getParameter("password"));
    UsernamePasswordToken uptoken=new UsernamePasswordToken(request.getParameter("username"),request.getParameter
            ("password"));
    Subject currentuser= SecurityUtils.getSubject();
    currentuser.login(uptoken);
    JSONObject json=new JSONObject();

    if (currentuser.isAuthenticated()) {
        json.append("status","true");
        UserInfo userInfo2 = userSevice.findByUsername((String)currentuser.getPrincipals().getPrimaryPrincipal
                ());
        //这里要把获取角色的方法要放到service里
        json.append("role",userInfo2.getRoleList().get(0).getId().toString());
        return json.toString();
    }
    else
        json.append("status","false");
    System.out.println(json.toString());
    return json.toString();
}
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



}
