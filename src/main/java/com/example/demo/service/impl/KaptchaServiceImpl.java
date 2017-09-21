package com.example.demo.service.impl;

import com.example.demo.service.KaptchaService;
import com.example.demo.service.exception.KaptchaFailException;
import com.google.code.kaptcha.Constants;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

@Service
public class KaptchaServiceImpl implements KaptchaService {

    private boolean isKaptchaTimeout(Subject subject) {
        long time = System.currentTimeMillis() - (Long) subject.getSession().getAttribute("kaptcha_create_time");
        if (time <= 30000)
            return true;
        return false;
    }

    @Override
    public boolean KaptchaValidate(Subject subject, String kaptcha_string) throws KaptchaFailException {
        try {
            if (isKaptchaTimeout(subject)) {

                if (kaptcha_string.equals(subject.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY)))
                    return true;
                else
                    throw new KaptchaFailException("100001", "验证码错误");

            } else
                throw new KaptchaFailException("100002", "验证码超时");
        } catch (NullPointerException e) {
            throw new KaptchaFailException("100000", "please refresh kaptcha image");
        }
    }
}
