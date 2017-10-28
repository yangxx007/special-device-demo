package com.example.demo.dao.map;

import com.example.demo.entity.data.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yang on 2017/8/12.
 */
public interface CityDao extends JpaRepository<City,Integer>{
    public City getCityById(int id);
    public City getCityByProvinceId(int province_id);
}
