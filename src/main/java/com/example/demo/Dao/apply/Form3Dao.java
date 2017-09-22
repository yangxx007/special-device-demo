package com.example.demo.Dao.apply;
import com.example.demo.entity.formModel.Form3;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yang on 2017/8/12.
 */
public interface Form3Dao extends JpaRepository<Form3,Integer>{
    public Form3 getApply3ById(Long id);
}

