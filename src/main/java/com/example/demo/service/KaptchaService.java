package com.example.demo.service;

import com.example.demo.service.exception.KaptchaFailException;
import org.apache.shiro.subject.Subject;
/**
 * @author yang
 * @create_at 2017/10/17
 **/
public interface KaptchaService {
    public boolean KaptchaValidate(Subject subject,String kaptcha_string) throws KaptchaFailException;
}
