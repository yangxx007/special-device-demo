package com.example.demo.service;

import com.example.demo.entity.data.ApplyInfo;
import com.example.demo.entity.device.DeviceInfo;

/**
 * @author yang
 * @create_at 17-10-27
 **/
public interface Apply2DeviceService {
    DeviceInfo apply2Device(ApplyInfo applyInfo,boolean pass);
}
