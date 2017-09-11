package com.example.demo.service;

import java.util.List;


/**
 * Created by yang on 2017/7/27.
 */
public interface ValidateService {
    public boolean isIdEqual(Long id);

    public boolean isDuplicateLogin(Long id);

    public boolean validateForm ();
}
