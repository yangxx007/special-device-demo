package com.example.demo.Dao.apply;
import com.example.demo.entity.applyModel.Apply2;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yang on 2017/8/12.
 */
public interface Apply2Dao extends JpaRepository<Apply2,Integer>{
    public Apply2 getApply2ById(Long id);
}
