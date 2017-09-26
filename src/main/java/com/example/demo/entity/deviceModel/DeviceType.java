package com.example.demo.entity.deviceModel;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class DeviceType implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private byte forNormalUser;
    private byte forCompany;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte getForNormalUser() {
        return forNormalUser;
    }

    public void setForNormalUser(byte forNormalUser) {
        this.forNormalUser = forNormalUser;
    }

    public byte getForCompany() {
        return forCompany;
    }

    public void setForCompany(byte forCompany) {
        this.forCompany = forCompany;
    }


}
