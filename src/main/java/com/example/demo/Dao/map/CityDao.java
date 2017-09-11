package com.example.demo.Dao.map;

import com.example.demo.entity.dataModel.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yang on 2017/8/12.
 */
public interface CityDao extends JpaRepository<City,Integer>{
    public City getCityById(int id);
    public City getCityByProvince_id(int province_id);
}
