package com.example.demo.Dao.map;

import com.example.demo.entity.dataModel.City;
import com.example.demo.entity.dataModel.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictDao  extends JpaRepository<District,Integer> {


    public List<District> findByLevel(int level);
    public List<District> findByLevelAndCodeLike(int level, String code);

}
