package com.example.demo.service;

import com.example.demo.connector.conditions.DeviceConditions;
import com.example.demo.entity.device.DeviceInfo;
import com.example.demo.enums.CustomePage;
import org.apache.shiro.session.Session;

/**
 * @author yang
 * @create_at 17-10-26
 **/
public interface DeviceService {
    DeviceInfo  getDeviceById(long id,Session session);
    DeviceInfo  save(DeviceInfo deviceInfo);
}
