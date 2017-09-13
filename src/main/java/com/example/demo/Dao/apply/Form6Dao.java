package com.example.demo.Dao.apply;

import com.example.demo.entity.formModel.Form6;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yang on 2017/8/12.
 */
public interface Form6Dao extends JpaRepository<Form6,Integer>{
    public Form6 getApply6ById(Long id);
}
