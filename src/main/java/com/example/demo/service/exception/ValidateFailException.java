package com.example.demo.service.exception;

public class ValidateFailException extends RuntimeException{
    public ValidateFailException() {
        super();
    }

    public ValidateFailException(String message) {
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
