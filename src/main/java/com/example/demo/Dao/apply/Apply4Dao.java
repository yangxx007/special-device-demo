package com.example.demo.Dao.apply;

import com.example.demo.entity.applyModel.Apply4;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yang on 2017/8/12.
 */
public interface Apply4Dao extends JpaRepository<Apply4,Integer>{
    public Apply4 getApply4ById(Long id);
}
