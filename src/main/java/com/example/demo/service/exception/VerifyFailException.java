package com.example.demo.service.exception;

public class VerifyFailException  extends RuntimeException{
    public VerifyFailException() {
        super();
    }

    public VerifyFailException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
