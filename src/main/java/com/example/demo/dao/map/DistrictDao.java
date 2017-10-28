package com.example.demo.dao.map;

import com.example.demo.entity.data.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictDao  extends JpaRepository<District,Integer> {


    public List<District> findByLevel(int level);
    public List<District> findByLevelAndCodeLike(int level, String code);

}
