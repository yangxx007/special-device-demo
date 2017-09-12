package com.example.demo.service;


import com.example.demo.entity.dataModel.ApplyInfo;

import java.util.List;


/**
 * Created by yang on 2017/7/26.
 */
public interface DataService {
    public List<Object> getApplyForms(ApplyInfo applyInfo);

    public List<Object> getFiles(ApplyInfo applyInfo);

}
