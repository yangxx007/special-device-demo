package com.example.demo.dao.device;

import com.example.demo.entity.device.DeviceInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author yang
 * @create_at 17-10-24
 **/
public interface DeviceDao extends PagingAndSortingRepository<DeviceInfo,Integer> {
DeviceInfo findByOwnerId(long id);
Page<DeviceInfo> findByAgencyId(long agencyId,Pageable page);
DeviceInfo findById(long id);
}
