package com.example.demo.service.impl;

import com.example.demo.Dao.apply.*;
import com.example.demo.entity.dataModel.ApplyInfo;
import com.example.demo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yang on 2017/9/12.
 */
@Service
public class DataServiceImpl implements DataService {
    private List<Object> data_set;
    @Autowired
    private Form1Dao form1Dao;
    @Autowired
    private Form2Dao form2Dao;
    @Autowired
    private Form3Dao form3Dao;
    @Autowired
    private Form4Dao form4Dao;
    @Autowired
    private Form5Dao form5Dao;
    @Autowired
    private Form6Dao form6Dao;
    @Autowired
    private Form7Dao form7Dao;
    @Autowired
    private Form8Dao apply8Dao;

    @Override
    public List<Object> getApplyForms(ApplyInfo applyInfo) {
        data_set=null;

        data_set.add(form1Dao.getApply1ById(applyInfo.getApply1()));

        data_set.add(form2Dao.getApply2ById(applyInfo.getApply2()));

        data_set.add(form3Dao.getApply3ById(applyInfo.getApply3()));

        data_set.add(form4Dao.getApply4ById(applyInfo.getApply4()));

        data_set.add(form5Dao.getApply5ById(applyInfo.getApply5()));

        data_set.add(form6Dao.getApply6ById(applyInfo.getApply6()));

        data_set.add(form7Dao.getApply7ById(applyInfo.getApply7()));

        data_set.add(apply8Dao.getApply8ById(applyInfo.getApply8()));

        return data_set;
    }

    @Override
    public List<Object> getFiles(ApplyInfo applyInfo) {

        return null;
    }
}
