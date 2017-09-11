package com.example.demo.Dao.apply;

import com.example.demo.entity.applyModel.Apply8;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yang on 2017/8/12.
 */
public interface Apply8Dao extends JpaRepository<Apply8,Integer>{
    public Apply8 getApply8ById(Long id);
}
