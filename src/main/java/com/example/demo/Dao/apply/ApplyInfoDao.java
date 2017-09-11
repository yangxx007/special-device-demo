package com.example.demo.Dao.apply;

import com.example.demo.entity.dataModel.ApplyInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yang on 2017/8/10.
 */
public interface ApplyInfoDao extends JpaRepository<ApplyInfo,Integer> {
    public ApplyInfo findApplyInfoById(Long id);
}
