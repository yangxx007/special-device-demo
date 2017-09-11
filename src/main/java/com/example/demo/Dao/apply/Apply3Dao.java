package com.example.demo.Dao.apply;
import com.example.demo.entity.applyModel.Apply3;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yang on 2017/8/12.
 */
public interface Apply3Dao extends JpaRepository<Apply3,Integer>{
    public Apply3 getApply3ById(Long id);
}

