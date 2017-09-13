package com.example.demo.Dao.apply;
import com.example.demo.entity.formModel.Form1;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yang on 2017/8/12.
 */
public interface Form1Dao extends JpaRepository<Form1,Integer>{
    public Form1 getApply1ById(Long id);
}
