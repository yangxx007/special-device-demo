package com.example.demo.service;

import com.example.demo.entity.device.DeviceType;

import java.util.List;

/**
 * @author  yang
 * @create_at 17-10-18
 **/
public interface DeviceTypeService {
     List<DeviceType> findAllCategory();
     List<DeviceType> findAllClass(String code);
     List<DeviceType> findAllType(String code);
}
