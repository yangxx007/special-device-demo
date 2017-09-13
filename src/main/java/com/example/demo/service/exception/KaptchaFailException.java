package com.example.demo.service.exception;

public class KaptchaFailException extends RuntimeException {
    private String retCd;
    private String msgDes;
    public KaptchaFailException() {
        super();
    }
    public  KaptchaFailException(String message)
    {
        super(message);
        this.msgDes=message;
    }
    public  KaptchaFailException(String retCd,String message)
    {
        super();
        this.msgDes=message;
        this.retCd=retCd;
    }
    public String getRetCd() {
        return retCd;
    }

    public String getMsgDes() {
        return msgDes;
    }
}
