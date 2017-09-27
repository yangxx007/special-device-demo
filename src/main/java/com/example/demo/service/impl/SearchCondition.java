package com.example.demo.service.impl;

import com.example.demo.entity.dataModel.ApplyInfo;
import com.example.demo.service.staticfunction.UtilServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchCondition  {
    @Autowired
    private EntityManager em;
    private int page=0;
    private int size=3;
    private int OderBy=1;
    private String[] time;
    private int applyTypeId;
    private int deviceTypeId;
    //state 1 为提交，2为未提交 ，3为全部
    private int states=0;
    private String format = "yyyy-MM-dd";
    private long[] parseTime() throws Exception{
        long[] long_time=new long[2];
        if(time!=null){
            long_time[0]= UtilServiceImpl.string2Long(time[0],format);
            long_time[1]=UtilServiceImpl.string2Long(time[1],format)+ 86400000;
            return long_time;
        }
        long_time[0]=0;
        long_time[1]=UtilServiceImpl.date2Long(new Date());
        return long_time;
    }
    public List<ApplyInfo> searchByConditions() throws  Exception{

        long[] long_time=parseTime();
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery cq = qb.createQuery();
        Root<ApplyInfo> customer = cq.from(ApplyInfo.class);

        //Constructing list of parameters
        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(qb.between(customer.get("createTime"),long_time[0],long_time[1]));
        //Adding predicates in case of parameter not being null
        if (applyTypeId != 0) {
            predicates.add(
                    qb.equal(customer.get("applyTypeId"), applyTypeId));
        }
        if (deviceTypeId != 0) {
            predicates.add(
                    qb.equal(customer.get("deviceTypeId"), deviceTypeId));
        }
        if (states!=0){
            predicates.add(
                    qb.equal(customer.get("states"), states));
        }
        //query itself
        cq.select(customer)
                .where(predicates.toArray(new Predicate[]{}));
        //execute query and do something with result
        return em.createQuery(cq).getResultList();
    }
}
