package com.example.demo.Dao.apply;

import com.example.demo.entity.applyModel.Apply5;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yang on 2017/8/12.
 */
public interface Apply5Dao extends JpaRepository<Apply5,Integer>{
    public Apply5 getApply5ById(Long id);
}
