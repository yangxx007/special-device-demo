package com.example.demo.entity.deviceModel;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;

@Entity
public class DeviceStatus implements Serializable{
    @Id
    @GeneratedValue
    private Long id;

    private String device_name;
    private Long owner;
    private String province;
    private String city;
    private String area;
    private Timestamp create_at;
    private Integer state;
    private Long create_apply_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getCreate_apply_id() {
        return create_apply_id;
    }

    public void setCreate_apply_id(Long create_apply_id) {
        this.create_apply_id = create_apply_id;
    }
}
