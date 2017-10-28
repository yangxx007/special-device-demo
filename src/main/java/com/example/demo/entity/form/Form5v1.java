package com.example.demo.entity.form;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author yang
 * @create_at 17-10-25
 **/
@Entity
public class Form5v1 implements Serializable{
    @Id@GeneratedValue
    private long id;
    private String eqVariety;
    private String useRegCode;
    private String eqCode;
    private String eqUseLoc;
    private String productNum;
    private String cancelReason;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEqVariety() {
        return eqVariety;
    }

    public void setEqVariety(String eqVariety) {
        this.eqVariety = eqVariety;
    }

    public String getUseRegCode() {
        return useRegCode;
    }

    public void setUseRegCode(String useRegCode) {
        this.useRegCode = useRegCode;
    }

    public String getEqCode() {
        return eqCode;
    }

    public void setEqCode(String eqCode) {
        this.eqCode = eqCode;
    }

    public String getEqUseLoc() {
        return eqUseLoc;
    }

    public void setEqUseLoc(String eqUseLoc) {
        this.eqUseLoc = eqUseLoc;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }
}
