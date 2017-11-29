package com.example.demo.dao.device;

import com.example.demo.entity.form.SubForm;
import com.example.demo.enums.DeviceTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author yang
 * @create_at 17-11-21
 **/
public interface MultiDeviceDao extends JpaRepository<SubForm,Integer> {
      SubForm findByOwnerIdAndEqCodeAndDeviceType(long ownerId,String EqCode,DeviceTypeEnum deviceType);
      List<SubForm> findByOwnerIdAndDeviceType(long ownerId, DeviceTypeEnum deviceType);
}
