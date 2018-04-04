package com.example.demo.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

/**
 * @author yang
 * @create_at 17-10-30
 **/
public class BaseController {

    protected Session getSession(){

        return SecurityUtils.getSubject().getSession();

    }

}
