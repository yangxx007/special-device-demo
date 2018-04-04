package com.example.demo.service.exception;

public class FileFailException extends CustomException {


    public FileFailException() {
        super();
    }

    public FileFailException(String message) {
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
