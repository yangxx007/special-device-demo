package com.example.demo.service.impl;

import com.example.demo.Dao.map.DistrictDao;
import com.example.demo.entity.dataModel.District;
import com.example.demo.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapServiceImpl implements MapService {
    @Autowired
    private DistrictDao districtDao;

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
}
