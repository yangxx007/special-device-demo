package com.example.demo.connector.updater;

import com.example.demo.entity.data.ApplyInfo;
import com.example.demo.entity.form.Form;
import com.example.demo.enums.ApplyTypeEnum;

import java.io.Serializable;
import java.util.List;

/**
 * @author yang
 * @create_at 17-11-13
 **/
public class DropOrStopApplyHandler implements Serializable{
    private long[] deviceId;
    private ApplyTypeEnum applyType;
    private List<Form> formList;
    public ApplyInfo getApply(){
        ApplyInfo applyInfo=new ApplyInfo();
        applyInfo.setDeviceList(deviceId);
        applyInfo.setApplyType(applyType);
        applyInfo.setFormList(formList);
        return applyInfo;
    }
    public long[] getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long[] deviceId) {
        this.deviceId = deviceId;
    }

    public ApplyTypeEnum getApplyType() {
        return applyType;
    }

    public void setApplyType(ApplyTypeEnum applyType) {
        this.applyType = applyType;
    }

    public List<Form> getFormList() {
        return formList;
    }

    public void setFormList(List<Form> formList) {
        this.formList = formList;
    }
}
