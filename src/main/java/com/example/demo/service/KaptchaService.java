package com.example.demo.service;

import com.example.demo.service.exception.KaptchaFailException;
import org.apache.shiro.subject.Subject;

public interface KaptchaService {
    public boolean KaptchaValidate(Subject subject,String kaptcha_string) throws KaptchaFailException;
}
