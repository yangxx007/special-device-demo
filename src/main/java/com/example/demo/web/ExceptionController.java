package com.example.demo.web;

import com.example.demo.enums.JsonResponse;
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
}
