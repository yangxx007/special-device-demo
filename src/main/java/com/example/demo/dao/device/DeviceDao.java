package com.example.demo.dao.device;

import com.example.demo.entity.device.DeviceInfo;
import com.example.demo.enums.DeviceTypeEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author yang
 * @create_at 17-10-24
 **/
public interface DeviceDao extends PagingAndSortingRepository<DeviceInfo,Integer> {
DeviceInfo findByOwnerId(long id);
Page<DeviceInfo> findByAgencyId(long agencyId,Pageable page);
DeviceInfo findById(long id);
long countAllByDeviceType(DeviceTypeEnum deviceTypeEnum);
List<DeviceInfo> findAllByOwnerId(long id);
long countAllByDeviceCode(String deviceCode);
}
