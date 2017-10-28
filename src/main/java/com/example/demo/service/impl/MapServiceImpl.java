package com.example.demo.service.impl;

import com.example.demo.dao.map.DistrictDao;
import com.example.demo.dao.map.OrganizationDao;
import com.example.demo.entity.data.District;
import com.example.demo.entity.data.Organization;
import com.example.demo.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MapServiceImpl implements MapService {
    @Autowired
    private DistrictDao districtDao;
    @Autowired
    private OrganizationDao organizationDao;

    @Override
    public List<District> findAllProvince() {
        int level = 1;
        return districtDao.findByLevel(level);
    }

    @Override
    public List<District> findAllCity(String code) {
        String subCode = code.substring(0,2);
        int level = 2;
        code = subCode + "%";
        return districtDao.findByLevelAndCodeLike(level,code);
    }

    @Override
    public List<District> findAllArea(String code) {
        int level = 3;
        String subCode = code.substring(0,4);
        code = subCode + "%";
        return districtDao.findByLevelAndCodeLike(level,code);
    }

    @Override
    public List<Organization> findOrganizationsByCode(String code) {
        List<Organization> organizations=new ArrayList<>();
        organizations.addAll(organizationDao.findByDistrictCode(code.substring(0,2)+"0000"));
        if((Integer.parseInt(code)%100)==0){
            organizations.addAll(organizationDao.findByDistrictCodeLike(code.substring(0,4)+"%"));
        }
        else {
            organizations.addAll(organizationDao.findByDistrictCode(code.substring(0,4)+"00"));
            organizations.addAll(organizationDao.findByDistrictCode(code));
        }
        return organizations;

    }
}
