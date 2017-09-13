package com.example.demo.Dao.apply;

import com.example.demo.entity.formModel.Form4;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yang on 2017/8/12.
 */
public interface Form4Dao extends JpaRepository<Form4,Integer>{
    public Form4 getApply4ById(Long id);
}
