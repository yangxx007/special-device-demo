package com.example.demo.config;

import com.octo.captcha.engine.image.gimpy.GmailEngine;
import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.captchastore.FastHashMapCaptchaStore;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yang on 2017/9/12.
 */
public class Jcaptcha {


    public static final MyImageCaptchaService captchaService
            =new MyImageCaptchaService(new FastHashMapCaptchaStore(),
            new GmailEngine(), 180,100000,75000);

    public static boolean validateResponse(
            HttpServletRequest request, String userCaptchaResponse) {
        if (request.getSession(false) == null) return false;
        boolean validated = false;
        try {
            String id = request.getSession().getId();
            validated =
                    captchaService.validateResponseForID(id, userCaptchaResponse)
                            .booleanValue();
        } catch (CaptchaServiceException e) {
            e.printStackTrace();
        }
        return validated;
    }

    public static boolean hasCaptcha(
            HttpServletRequest request, String userCaptchaResponse) {
        if (request.getSession(false) == null) return false;
        boolean validated = false;
        try {
            String id = request.getSession().getId();
            validated = captchaService.hasCapcha(id, userCaptchaResponse);
        } catch (CaptchaServiceException e) {
            e.printStackTrace();
        }
        return validated;
    }
}