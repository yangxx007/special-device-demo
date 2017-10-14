package com.example.demo.Dao.map;

import com.example.demo.entity.dataModel.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganizationDao extends JpaRepository<Organization,Integer> {
    public List<Organization> findByDistrictCode(String code);
    public List<Organization> findByDistrictCodeLike(String likeCode);
}
