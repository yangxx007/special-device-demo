package com.example.demo.dao.map;

import com.example.demo.entity.data.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganizationDao extends JpaRepository<Organization,Integer> {
    public List<Organization> findByDistrictCode(String code);
    public List<Organization> findByDistrictCodeLike(String likeCode);
}
