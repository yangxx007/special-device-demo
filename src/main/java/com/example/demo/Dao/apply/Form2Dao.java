package com.example.demo.Dao.apply;
import com.example.demo.entity.formModel.Form2;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yang on 2017/8/12.
 */
public interface Form2Dao extends JpaRepository<Form2,Integer>{
    public Form2 getApply2ById(Long id);
}
