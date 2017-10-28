package com.example.demo.service;


import com.example.demo.entity.data.ApplyInfo;

import java.util.List;
/**
 * @author yang
 * @create_at 2017/10/17
 **/

public interface DataService {


    public List<Object> getFiles(ApplyInfo applyInfo);

}
