package com.example.demo.Dao.apply;
import com.example.demo.entity.applyModel.Apply7;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yang on 2017/8/12.
 */
public interface Apply7Dao extends JpaRepository<Apply7,Integer>{
    public Apply7 getApply7ById(Long id);
}
