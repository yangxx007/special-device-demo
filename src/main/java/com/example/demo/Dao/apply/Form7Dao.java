package com.example.demo.Dao.apply;
import com.example.demo.entity.formModel.Form7;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yang on 2017/8/12.
 */
public interface Form7Dao extends JpaRepository<Form7,Integer>{
    public Form7 getApply7ById(Long id);
}
