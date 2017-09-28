package com.example.demo.service;

import com.example.demo.entity.dataModel.District;
import com.example.demo.entity.dataModel.Organization;

import java.util.List;

public interface MapService {

    public List<District> findAllProvince();
    public List<District> findAllCity(String code);
    public List<District> findAllArea(String code);
    public List<Organization> findAllOrganization(String code,int level);

}
