package com.example.demo.entity.device;

import com.example.demo.enums.ApplyTypeEnum;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author yang
 * @create_at 17-11-9
 **/
@Entity
public class DeviceLogs {
    @Id
    private long applyId;
    private ApplyTypeEnum applyType;
    private String updateTime;

    public long getApplyId() {
        return applyId;
    }

    public void setApplyId(long applyId) {
        this.applyId = applyId;
    }

    public ApplyTypeEnum getApplyType() {
        return applyType;
    }

    public void setApplyType(ApplyTypeEnum applyType) {
        this.applyType = applyType;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
