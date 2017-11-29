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
        List<Form> newFormList = applyInfo.getFormList();
        List<Form> lastFormList=new ArrayList<>();
        //find form type if form exist in the new form list,if not save original form
        for (int i=0;i< formList.size();i++) {
            for (int j=0;j<newFormList.size();j++) {
                if (formList.get(i).getFormType() == newFormList.get(j).getFormType()) {
                    break;
                }
                if(j==newFormList.size()){
                    lastFormList.add(formList.get(i));
                }
            }
        }
        lastFormList.addAll(newFormList);
        applyInfo.setFormList(lastFormList);
        applyInfo.setCreateTime(UtilServiceImpl.date2Long(new Date()));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
