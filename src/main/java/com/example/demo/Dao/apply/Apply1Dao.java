package com.example.demo.Dao.apply;
import com.example.demo.entity.applyModel.Apply1;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yang on 2017/8/12.
 */
public interface Apply1Dao extends JpaRepository<Apply1,Integer>{
    public Apply1 getApply1ById(Long id);
}
