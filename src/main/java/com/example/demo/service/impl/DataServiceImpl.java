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
    private Apply1Dao apply1Dao;
    @Autowired
    private Apply2Dao apply2Dao;
    @Autowired
    private Apply3Dao apply3Dao;
    @Autowired
    private Apply4Dao apply4Dao;
    @Autowired
    private Apply5Dao apply5Dao;
    @Autowired
    private Apply6Dao apply6Dao;
    @Autowired
    private Apply7Dao apply7Dao;
    @Autowired
    private Apply8Dao apply8Dao;

    @Override
    public List<Object> getApplyForms(ApplyInfo applyInfo) {
        data_set=null;

        data_set.add(apply1Dao.getApply1ById(applyInfo.getApply_1()));

        data_set.add(apply2Dao.getApply2ById(applyInfo.getApply_2()));

        data_set.add(apply3Dao.getApply3ById(applyInfo.getApply_3()));

        data_set.add(apply4Dao.getApply4ById(applyInfo.getApply_4()));

        data_set.add(apply5Dao.getApply5ById(applyInfo.getApply_5()));

        data_set.add(apply6Dao.getApply6ById(applyInfo.getApply_6()));

        data_set.add(apply7Dao.getApply7ById(applyInfo.getApply_7()));

        data_set.add(apply8Dao.getApply8ById(applyInfo.getApply_8()));

        return data_set;
    }

    @Override
    public List<Object> getFiles(ApplyInfo applyInfo) {

        return null;
    }
}
