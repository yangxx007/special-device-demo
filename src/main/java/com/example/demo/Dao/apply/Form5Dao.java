package com.example.demo.Dao.apply;

import com.example.demo.entity.formModel.Form5;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yang on 2017/8/12.
 */
public interface Form5Dao extends JpaRepository<Form5,Integer>{
    public Form5 getApply5ById(Long id);
}
