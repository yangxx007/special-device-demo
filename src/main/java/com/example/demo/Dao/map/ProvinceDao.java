package com.example.demo.Dao.map;

import com.example.demo.entity.dataModel.Province;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by yang on 2017/8/12.
 */
public interface ProvinceDao extends JpaRepository<Province,Integer>{
    public Province getProvinceById(int id);

}
