package com.example.demo.Dao.device;
import com.example.demo.entity.deviceModel.DeviceLogs;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yang on 2017/8/12.
 */
public interface DeviceLogDao extends JpaRepository<DeviceLogs,Integer>{
    public DeviceLogs getDeviceLogsByDevice_Id(Long id);
}
