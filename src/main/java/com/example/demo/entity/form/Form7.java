package com.example.demo.entity.form;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cylinders")
public class Form7 extends Form {
    @Id
    @GeneratedValue
    private long id;
    private String useCompany;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "applyCylinders",joinColumns = {@JoinColumn(name = "formId")}, inverseJoinColumns = {@JoinColumn(name = "deviceId")})
    private List<Form7v1> subList;
    private String formFillDate;
    private String manager;
    private String telephone;
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUseCompany() {
        return useCompany;
    }

    public void setUseCompany(String useCompany) {
        this.useCompany = useCompany;
    }

    public String getFormFillDate() {
        return formFillDate;
    }

    public void setFormFillDate(String formFillDate) {
        this.formFillDate = formFillDate;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Form7v1> getSubList() {
        return subList;
    }

    public void setSubList(List<Form7v1> subList) {
        this.subList = subList;
    }
}
