package com.example.demo.Dao.agency;

import com.example.demo.entity.dataModel.Adminstration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyDao extends JpaRepository<Adminstration,Integer> {

}
