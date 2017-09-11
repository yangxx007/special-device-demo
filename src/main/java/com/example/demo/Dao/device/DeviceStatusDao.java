package com.example.demo.Dao.device;
import com.example.demo.entity.deviceModel.DeviceStatus;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yang on 2017/8/12.
 */
public interface DeviceStatusDao extends JpaRepository<DeviceStatus,Integer>{
    public DeviceStatus getDeviceStatusById(Long id);
}
