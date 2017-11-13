package com.example.demo.service.impl;

import com.example.demo.dao.device.DeviceDao;
import com.example.demo.dao.device.UseRegistCertificateDao;
import com.example.demo.dao.map.DistrictDao;
import com.example.demo.dao.map.OrganizationDao;
import com.example.demo.entity.data.Organization;
import com.example.demo.entity.device.DeviceInfo;
import com.example.demo.entity.device.UseRegistCertificate;
import com.example.demo.enums.DeviceTypeEnum;
import com.example.demo.service.RegisterCertificateService;
import com.example.demo.service.utils.RegistCodeGenerater;
import com.example.demo.service.utils.UtilServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author yang
 * @create_at 17-11-13
 **/
@Service
public class CertificateServiceImpl implements RegisterCertificateService {
    @Autowired
    private UseRegistCertificateDao certificateDao;
    @Autowired
    private DeviceDao deviceDao;
    @Autowired
    private OrganizationDao organizationDao;
    @Autowired
    private DistrictDao districtDao;
    @Override
    public void createCertificate(DeviceInfo deviceInfo,Organization organization, String deviceCode, DeviceTypeEnum deviceTypeEnum)throws Exception{
        RegistCodeGenerater codeGenerater=new RegistCodeGenerater();
        String registCode=codeGenerater.generate(districtDao.findFirstByCode(organization.getDistrictCode()),deviceCode,deviceTypeEnum.getShortName(), UtilServiceImpl.date2Long(new Date()),deviceDao.countAllByDeviceType(deviceTypeEnum));
        deviceInfo.setRegistCode(registCode);
        UseRegistCertificate registCertificate=new UseRegistCertificate(deviceInfo);
        certificateDao.save(registCertificate);
    }
}
