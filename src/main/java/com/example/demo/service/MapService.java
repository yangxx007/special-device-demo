package com.example.demo.service;

import com.example.demo.entity.dataModel.District;

import java.util.List;

public interface MapService {

    public List<District> findAllProvince();
    public List<District> findAllCity(String code);
    public List<District> findAllArea(String code);

}
