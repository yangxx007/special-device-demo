package com.example.demo.service;

import com.example.demo.entity.data.District;
import com.example.demo.entity.data.Organization;

import java.util.List;
/**
 * @author yang
 * @create_at 2017/10/17
 **/
public interface MapService {

    public List<District> findAllProvince();
    public List<District> findAllCity(String code);
    public List<District> findAllArea(String code);
    List<Organization> findOrganizationsByCode(String code);

}
