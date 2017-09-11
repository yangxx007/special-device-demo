package com.example.demo.Dao.apply;

import com.example.demo.entity.applyModel.Apply6;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yang on 2017/8/12.
 */
public interface Apply6Dao extends JpaRepository<Apply6,Integer>{
    public Apply6 getApply6ById(Long id);
}
