package com.example.demo.entity.form;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sdCancellationofRe")
public class Form5    {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long  id;
    private String declarationType;
    private String noUseNum;
    private String useComName;
    private String useComAddr;
    private String safeAdmin;
    private String safeAdminTelephone;
    private String propertyComName;
    private String propertyComTelephone;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "CancelDevices",joinColumns = {@JoinColumn(name = "formId")},inverseJoinColumns = {@JoinColumn(name ="deviceId")})
    private List<Form5v1> subList;
    private String useCompanyOpinion;
    private String propertyCompanyOpinion;
    private String regAuthorityOpinion;
    private String regAuthorityStaff;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDeclarationType() {
        return declarationType;
    }

    public void setDeclarationType(String declarationType) {
        this.declarationType = declarationType;
    }

    public String getUseCompanyOpinion() {
        return useCompanyOpinion;
    }

    public void setUseCompanyOpinion(String useCompanyOpinion) {
        this.useCompanyOpinion = useCompanyOpinion;
    }

    public String getPropertyCompanyOpinion() {
        return propertyCompanyOpinion;
    }

    public void setPropertyCompanyOpinion(String propertyCompanyOpinion) {
        this.propertyCompanyOpinion = propertyCompanyOpinion;
    }

    public String getRegAuthorityOpinion() {
        return regAuthorityOpinion;
    }

    public void setRegAuthorityOpinion(String regAuthorityOpinion) {
        this.regAuthorityOpinion = regAuthorityOpinion;
    }

    public String getRegAuthorityStaff() {
        return regAuthorityStaff;
    }

    public void setRegAuthorityStaff(String regAuthorityStaff) {
        this.regAuthorityStaff = regAuthorityStaff;
    }

    public List<Form5v1> getSubList() {
        return subList;
    }

    public void setSubList(List<Form5v1> subList) {
        this.subList = subList;
    }

    public String getNoUseNum() {
        return noUseNum;
    }

    public void setNoUseNum(String noUseNum) {
        this.noUseNum = noUseNum;
    }

    public String getUseComName() {
        return useComName;
    }

    public void setUseComName(String useComName) {
        this.useComName = useComName;
    }

    public String getUseComAddr() {
        return useComAddr;
    }

    public void setUseComAddr(String useComAddr) {
        this.useComAddr = useComAddr;
    }

    public String getSafeAdmin() {
        return safeAdmin;
    }

    public void setSafeAdmin(String safeAdmin) {
        this.safeAdmin = safeAdmin;
    }

    public String getSafeAdminTelephone() {
        return safeAdminTelephone;
    }

    public void setSafeAdminTelephone(String safeAdminTelephone) {
        this.safeAdminTelephone = safeAdminTelephone;
    }

    public String getPropertyComName() {
        return propertyComName;
    }

    public void setPropertyComName(String propertyComName) {
        this.propertyComName = propertyComName;
    }

    public String getPropertyComTelephone() {
        return propertyComTelephone;
    }

    public void setPropertyComTelephone(String propertyComTelephone) {
        this.propertyComTelephone = propertyComTelephone;
    }
}
