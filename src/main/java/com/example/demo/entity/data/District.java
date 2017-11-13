package com.example.demo.entity.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class District implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String provinceCode;
    private String name;
    private String code;
    private String citySeqCode;
    private String areaSeqCode;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    private Integer level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCitySeqCode() {
        return citySeqCode;
    }

    public void setCitySeqCode(String citySeqCode) {
        this.citySeqCode = citySeqCode;
    }

    public String getAreaSeqCode() {
        return areaSeqCode;
    }

    public void setAreaSeqCode(String areaSeqCode) {
        this.areaSeqCode = areaSeqCode;
    }
}
