package com.example.demo.dao.apply;

import com.example.demo.entity.data.ApplyFormType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yang on 2017/8/12.
 */
public interface FormTypeDao extends JpaRepository<ApplyFormType,Integer>{
    public ApplyFormType getApplyFormTypeById(int id);
}
