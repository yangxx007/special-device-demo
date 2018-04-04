package com.example.demo.service.impl;

import com.example.demo.dao.device.DeviceTypeDao;
import com.example.demo.entity.device.DeviceType;
import com.example.demo.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yang
 * @create_at 17-10-18
 **/
@Service
public class DeviceTypeServiceImpl implements DeviceTypeService{
    @Autowired
    private DeviceTypeDao deviceTypeDao;

    @Override
    public List<DeviceType> findAllCategory() {
        int level = 1;
        return deviceTypeDao.findByLevel(level);
    }

    @Override
    public List<DeviceType> findAllClass(String code) {
        String subCode = code.substring(0,1);
        int level = 2;
        code = subCode + "%";
        return deviceTypeDao.findByLevelAndCodeLike(level,code);
    }

    @Override
    public List<DeviceType> findAllType(String code) {
        int level = 3;
        String subCode = code.substring(0,2);
        code = subCode + "%";
        return deviceTypeDao.findByLevelAndCodeLike(level,code);
    }
}

