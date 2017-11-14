package com.example.demo.connector.updater;


import com.example.demo.entity.data.ApplyInfo;
import com.example.demo.entity.form.*;
import com.example.demo.service.utils.UtilServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author yang
 * @create_at 17-10-26
 **/
public class ApplyUpdater implements Serializable {
    private long id;

    public List<Form> getFormList() {
        return formList;
    }

    public void setFormList(List<Form> formList) {
        this.formList = formList;
    }

    private List<Form> formList;

    public void update(ApplyInfo applyInfo){
        applyInfo.setFormList(formList);
        applyInfo.setCreateTime(UtilServiceImpl.date2Long(new Date()));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
