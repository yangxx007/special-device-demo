package com.example.demo.dao.agency;

import com.example.demo.entity.data.Adminstration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyDao extends JpaRepository<Adminstration,Integer> {

}
