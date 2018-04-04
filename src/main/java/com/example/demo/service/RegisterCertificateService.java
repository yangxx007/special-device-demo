package com.example.demo.service;

import com.example.demo.entity.data.District;
import com.example.demo.entity.data.Organization;
import com.example.demo.entity.device.DeviceInfo;
import com.example.demo.enums.DeviceTypeEnum;

/**
 * @author yang
 * @create_at 17-11-13
 **/
public interface RegisterCertificateService {
    public void createCertificate(DeviceInfo deviceInfo, Organization organization, String deviceCode, DeviceTypeEnum deviceTypeEnum)throws Exception;
}
