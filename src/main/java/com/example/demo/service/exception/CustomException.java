package com.example.demo.service.exception;

public class CustomException extends RuntimeException{
    private String retCd;
    private String msgDes;
    public CustomException() {
        super();
    }
    public  CustomException(String message)
    {
        super(message);
        this.msgDes=message;
    }
    public  CustomException(String retCd,String message)
    {
        super();
        this.msgDes=message;
        this.retCd=retCd;
    }
    public String getCd() {
        return retCd;
    }
    @Override
    public String getMessage() {
        return msgDes;
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
