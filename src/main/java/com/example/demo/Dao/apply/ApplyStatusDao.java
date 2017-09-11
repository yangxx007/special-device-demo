package com.example.demo.Dao.apply;

import com.example.demo.entity.dataModel.ApplyStatus;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by yang on 2017/8/12.
 */
public interface ApplyStatusDao extends JpaRepository<ApplyStatus,Integer>{
    public ApplyStatus getApplyStatusByApply_Id(Long id);
}
