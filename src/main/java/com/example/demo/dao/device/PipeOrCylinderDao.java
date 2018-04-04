package com.example.demo.dao.device;

import com.example.demo.entity.form.SubForm;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author yang
 * @create_at 17-11-14
 **/
public interface PipeOrCylinderDao extends JpaRepository<SubForm,Integer> {
    SubForm findByEqCode(String eqCode);
}
