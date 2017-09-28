package com.example.demo.service.impl;

import com.example.demo.Dao.map.DistrictDao;
import com.example.demo.Dao.map.OrganizationDao;
import com.example.demo.entity.dataModel.District;
import com.example.demo.entity.dataModel.Organization;
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
    public List<District> findAllArea(String code ) {
        int level = 3;
        String subCode = code.substring(0,4);
        code = subCode + "%";
        return districtDao.findByLevelAndCodeLike(level,code);
    }

    @Override
    public List<Organization> findAllOrganization(String code, int level) {
        List<Organization> results = new ArrayList<Organization>();
        String code_province;
        switch (level){
            case 2:
                String codelike =  code.substring(0,4) + "%";
                results.addAll(organizationDao.findByDistrictCodeLike(codelike));
                code_province = code.substring(0,2) + "0000";
                results.addAll(organizationDao.findByDistrictCode(code_province));
                break;
            case 3:
                results.addAll(organizationDao.findByDistrictCode(code));
                String code_city = code.substring(0,4)+"00";
                results.addAll(organizationDao.findByDistrictCode(code_city));
                code_province = code.substring(0,2) + "0000";
                results.addAll(organizationDao.findByDistrictCode(code_province));
                break;

        }
        return results;
    }


}
