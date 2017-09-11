package com.example.demo.Dao.device;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.deviceModel.DeviceAction;
/**
 * Created by yang on 2017/8/12.
 */
public interface DeviceActionDao extends JpaRepository<DeviceAction,Integer>{
    public DeviceAction getDeviceActionByDeviceType_Name(String device_type);
    public DeviceAction getDeviceActionByDeviceType_Id(Long device_type_id);
}
