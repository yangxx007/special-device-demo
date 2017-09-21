package com.example.demo.web;

import com.example.demo.enums.JsonResponse;
import com.example.demo.service.exception.*;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ControllerAdvice
public class ExceptionController
{

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public
    JsonResponse handleException(Exception e){
        e.printStackTrace();
        return new JsonResponse(false,e.getClass().toString(),null);
    }
    @ExceptionHandler(value = {KaptchaFailException.class,NotFoundException.class,FileFailException.class,
            ValidateFailException.class, VerifyFailException.class})
    @ResponseBody
    public
    JsonResponse handleKaptchaFailException(Exception e){
        e.printStackTrace();
        return new JsonResponse(false,e.getMessage(),null);
    }
    @ExceptionHandler(value = UnknownAccountException.class)
    @ResponseBody
    public
    JsonResponse handleUnknownAccountException(Exception e){
        e.printStackTrace();
        return new JsonResponse(false,"用户名不存在",null);
    }
    @ExceptionHandler(value = IncorrectCredentialsException.class)
    @ResponseBody
    public
    JsonResponse handleIncorrectCredentialsException(Exception e){
        e.printStackTrace();
        return new JsonResponse(false,"密码输入错误",null);
    }


}
