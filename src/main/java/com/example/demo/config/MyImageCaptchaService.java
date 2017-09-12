package com.example.demo.config;

import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;

/**
 * Created by yang on 2017/9/12.
 */
public class MyImageCaptchaService extends DefaultManageableImageCaptchaService{
    public MyImageCaptchaService(com.octo.captcha.service.captchastore.CaptchaStore captchaStore,
                                 com.octo.captcha.engine.CaptchaEngine captchaEngine,
                                 int minGuarantedStorageDelayInSeconds,
                                 int maxCaptchaStoreSize,
                                 int captchaStoreLoadBeforeGarbageCollection){
        super(captchaStore, captchaEngine, minGuarantedStorageDelayInSeconds,
                maxCaptchaStoreSize, captchaStoreLoadBeforeGarbageCollection);
    }
    public boolean hasCapcha(String id, String userCaptchaResponse) {
        return store.getCaptcha(id).validateResponse(userCaptchaResponse);
    }
}

