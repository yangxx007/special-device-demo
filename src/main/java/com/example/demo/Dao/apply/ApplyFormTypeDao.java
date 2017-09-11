package com.example.demo.Dao.apply;

import com.example.demo.entity.dataModel.ApplyFormType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yang on 2017/8/12.
 */
public interface ApplyFormTypeDao extends JpaRepository<ApplyFormType,Integer>{
    public ApplyFormType getApplyFormTypeById(int id);
}
