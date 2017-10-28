package com.example.demo.dao.device;
import com.example.demo.entity.device.DeviceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by yang on 2017/8/12.
 */
public interface  DeviceTypeDao extends JpaRepository<DeviceType,Integer>{
    public List<DeviceType> findByLevel(int level);
    public List<DeviceType> findByLevelAndCodeLike(int level,String code);
}
