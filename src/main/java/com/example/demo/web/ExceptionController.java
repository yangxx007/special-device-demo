package com.example.demo.web;

import com.example.demo.enums.JsonResponse;
import com.example.demo.service.exception.*;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @author yang
 * @create_at 2017/10/17
 **/
@Controller
@ControllerAdvice
public class ExceptionController
{

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public
    JsonResponse handleException(Exception e, HttpServletResponse response){
        e.printStackTrace();
        response.setStatus(500);
        return new JsonResponse(500,e.getClass().getSimpleName(),null);
    }
    @ExceptionHandler(value =CustomException.class)
    @ResponseBody
    public
    JsonResponse handleKaptchaFailException(Exception e){
        e.printStackTrace();
        return new JsonResponse(500,e.getMessage(),null);
    }
    @ExceptionHandler(value ={ValidateFailException.class, UnauthorizedException.class, UnauthenticatedException.class})
    @ResponseBody
    public JsonResponse UnauthorizedException(Exception e,HttpServletResponse response){
        response.setStatus(401);
        e.printStackTrace();
        return new JsonResponse(401,e.getMessage(),null);
    }
    @ExceptionHandler(value = UnknownAccountException.class)
    @ResponseBody
    public
    JsonResponse handleUnknownAccountException(Exception e,HttpServletResponse response){
        response.setStatus(200);
        e.printStackTrace();
        return new JsonResponse(400,"用户名不存在",null);
    }
    @ExceptionHandler(value = IncorrectCredentialsException.class)
    @ResponseBody
    public
    JsonResponse handleIncorrectCredentialsException(Exception e,HttpServletResponse response){
        response.setStatus(200);
        e.printStackTrace();
        return new JsonResponse(400,"密码输入错误",null);
    }


}
