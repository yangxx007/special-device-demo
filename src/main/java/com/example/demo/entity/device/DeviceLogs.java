package com.example.demo.entity.device;

import com.example.demo.enums.ApplyTypeEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author yang
 * @create_at 17-11-9
 **/
@Entity
public class DeviceLogs {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private long applyId;
    private ApplyTypeEnum applyType;
    private long updateTime;

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

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }
}
