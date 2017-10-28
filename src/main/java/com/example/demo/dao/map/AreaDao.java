package com.example.demo.dao.map;

import com.example.demo.entity.data.Area;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yang on 2017/8/12.
 */
public interface AreaDao extends JpaRepository<Area,Integer>{
    public Area getAreaByCityIdAndProvinceId(long city_id,long province_id);
    public Area getAreaById(long id);
}
