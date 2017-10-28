package com.example.demo.entity.form;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author yang
 * @create_at 17-10-25
 **/
@Entity
public class Form2v1 {
    @Id
    @GeneratedValue
    private long id;
    private String manuComName;
    private String manufactureDate;
    private String productNum;
    private String companyCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getManuComName() {
        return manuComName;
    }

    public void setManuComName(String manuComName) {
        this.manuComName = manuComName;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}
