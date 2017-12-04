package com.example.demo.connector.updater;


import com.example.demo.entity.data.ApplyInfo;
import com.example.demo.entity.form.*;
import com.example.demo.service.utils.UtilServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
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

    public void update(ApplyInfo applyInfo) {
        List<Form> lastFormList = applyInfo.getFormList();
        List<Form> newFormList=new ArrayList<>();
        //if the form list do not have the specify form from the last form list then add it into new form list
        for (int i=0;i< lastFormList.size();i++) {
            for (int j=0;j<=formList.size();j++) {
                if(j==formList.size()){
                    newFormList.add(lastFormList.get(i));
                    break;
                }
                if (formList.get(j).getFormType() == lastFormList.get(i).getFormType()) {
                    break;
                }
            }
        }
        newFormList.addAll(formList);
        applyInfo.setFormList(newFormList);
        applyInfo.setCreateTime(UtilServiceImpl.date2Long(new Date()));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
