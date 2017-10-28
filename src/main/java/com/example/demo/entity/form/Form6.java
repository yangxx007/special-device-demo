package com.example.demo.entity.form;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "IndustrialPiping")
public class Form6 extends Form  {
    @Id
    @GeneratedValue
    private long id;
    private String useCompany;
    private String useCompanyAdd;
    private String engineeringDevice;
    private String safetyDepartment;
    private String securityAdmin;
    @OneToMany(cascade =CascadeType.ALL)
    @JoinTable(name = "applyPipings",joinColumns = {@JoinColumn(name = "formId")},inverseJoinColumns = {@JoinColumn(name ="deviceId")})
    private List<Form6v1> subList;
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

    public String getUseCompanyAdd() {
        return useCompanyAdd;
    }

    public void setUseCompanyAdd(String useCompanyAdd) {
        this.useCompanyAdd = useCompanyAdd;
    }

    public String getEngineeringDevice() {
        return engineeringDevice;
    }

    public void setEngineeringDevice(String engineeringDevice) {
        this.engineeringDevice = engineeringDevice;
    }

    public String getSafetyDepartment() {
        return safetyDepartment;
    }

    public void setSafetyDepartment(String safetyDepartment) {
        this.safetyDepartment = safetyDepartment;
    }

    public String getSecurityAdmin() {
        return securityAdmin;
    }

    public void setSecurityAdmin(String securityAdmin) {
        this.securityAdmin = securityAdmin;
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

    public List<Form6v1> getSubList() {
        return subList;
    }

    public void setSubList(List<Form6v1> subList) {
        this.subList = subList;
    }
}
