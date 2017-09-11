package com.example.demo.entity.dataModel;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class ApplyInfo implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private long device_id;
    private int acceptor_adminstration_id;
    private int approver_adminstration_id;
    private boolean has_file;
    private String action;
    private int device_type_id;
    private String files_id;
    private Long apply_1;
    private Long apply_2;
    private Long apply_3;
    private Long apply_4;
    private Long apply_5;
    private Long apply_6;
    private Long apply_7;
    private Long apply_8;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDevice_id() {
        return device_id;
    }

    public void setDevice_id(Long device_id) {
        this.device_id = device_id;
    }

    public Integer getAcceptor_adminstration_id() {
        return acceptor_adminstration_id;
    }

    public void setAcceptor_adminstration_id(Integer acceptor_adminstration_id) {
        this.acceptor_adminstration_id = acceptor_adminstration_id;
    }

    public Integer getApprover_adminstration_id() {
        return approver_adminstration_id;
    }

    public void setApprover_adminstration_id(Integer approver_adminstration_id) {
        this.approver_adminstration_id = approver_adminstration_id;
    }

    public boolean isHas_file() {
        return has_file;
    }

    public void setHas_file(boolean has_file) {
        this.has_file = has_file;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getDevice_type_id() {
        return device_type_id;
    }

    public void setDevice_type_id(Integer device_type_id) {
        this.device_type_id = device_type_id;
    }

    public String getFiles_id() {
        return files_id;
    }

    public void setFiles_id(String files_id) {
        this.files_id = files_id;
    }

    public Long getApply_1() {
        return apply_1;
    }

    public void setApply_1(Long apply_1) {
        this.apply_1 = apply_1;
    }

    public Long getApply_2() {
        return apply_2;
    }

    public void setApply_2(Long apply_2) {
        this.apply_2 = apply_2;
    }

    public Long getApply_3() {
        return apply_3;
    }

    public void setApply_3(Long apply_3) {
        this.apply_3 = apply_3;
    }

    public Long getApply_4() {
        return apply_4;
    }

    public void setApply_4(Long apply_4) {
        this.apply_4 = apply_4;
    }

    public Long getApply_5() {
        return apply_5;
    }

    public void setApply_5(Long apply_5) {
        this.apply_5 = apply_5;
    }

    public Long getApply_6() {
        return apply_6;
    }

    public void setApply_6(Long apply_6) {
        this.apply_6 = apply_6;
    }

    public Long getApply_7() {
        return apply_7;
    }

    public void setApply_7(Long apply_7) {
        this.apply_7 = apply_7;
    }

    public Long getApply_8() {
        return apply_8;
    }

    public void setApply_8(Long apply_8) {
        this.apply_8 = apply_8;
    }




}
