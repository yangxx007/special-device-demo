package com.example.demo.Dao.device;
import com.example.demo.entity.deviceModel.DeviceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by yang on 2017/8/12.
 */
public interface  DeviceTypeDao extends JpaRepository<DeviceType,Integer>{
    public List<DeviceType> getAllByIdNotNull();
}
