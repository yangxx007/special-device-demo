package com.example.demo.Dao.apply;

import com.example.demo.entity.formModel.Form8;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yang on 2017/8/12.
 */
public interface Form8Dao extends JpaRepository<Form8,Integer>{
    public Form8 getApply8ById(Long id);
}
