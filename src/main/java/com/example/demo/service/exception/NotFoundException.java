package com.example.demo.service.exception;

public class NotFoundException extends CustomException{
    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }

}
