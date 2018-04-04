package com.example.demo.web;

import com.example.demo.entity.user.UserInfo;
import com.example.demo.enums.JsonResponse;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @author yang
 * @create_at 2017/10/17
 **/
@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse createUser(@RequestBody UserInfo userInfo) throws Exception {

        userService.createUser(userInfo,1);
        return new JsonResponse();
    }
    @RequestMapping(value = "/acceptor", method = RequestMethod.POST)
    //@RequiresPermissions("acceptor:create")
    public @ResponseBody
    JsonResponse createAcceptor(@RequestBody UserInfo userInfo) throws Exception {

        userService.createUser(userInfo,2);
        return new JsonResponse();
    }

    @RequestMapping(value = "/approver", method = RequestMethod.POST)
    //@RequiresPermissions("approver:create")
    public @ResponseBody
    JsonResponse createApprover(@RequestBody UserInfo userInfo) throws Exception {

        userService.createUser(userInfo,3);
        return new JsonResponse();
    }
    @RequestMapping(value = "/supervisor", method = RequestMethod.POST)
    //@RequiresPermissions("acceptor:create")
    public @ResponseBody
    JsonResponse createSupervisor(@RequestBody UserInfo userInfo) throws Exception {

        userService.createUser(userInfo,4);
        return new JsonResponse();
    }
}
