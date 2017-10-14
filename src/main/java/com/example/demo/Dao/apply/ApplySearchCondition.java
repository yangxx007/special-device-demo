package com.example.demo.Dao.apply;

import com.example.demo.entity.dataModel.ApplyInfo;
import com.example.demo.entity.dataModel.ApplyStatus;
import com.example.demo.enums.ApplyConditions;
import com.example.demo.responseModel.ApplyResponse;
import com.example.demo.service.multiSearch.MultiSearch;

import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ApplySearchCondition extends MultiSearch {
   private ApplyConditions conditions;

    public List<? extends ApplyInfo> searchByConditions(EntityManager em) throws Exception{

        long[] long_time=conditions.parseTime("yyyy-MM-dd");
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery cq = qb.createQuery();
        Root<ApplyInfo> customer = cq.from(ApplyInfo.class);
        Root<ApplyStatus> appender=cq.from(ApplyStatus.class);
        //Constructing list of parameters
        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(qb.between(customer.get("createTime"),long_time[0],long_time[1]));
        //Adding predicates in case of parameter not being null
        if (conditions.getApplyTypeId() != 0) {
            predicates.add(
                    qb.equal(customer.get("applyType"), conditions.getApplyTypeId()));
        }
        if (conditions.getDeviceTypeId() != 0) {
            predicates.add(
                    qb.equal(customer.get("deviceType"), conditions.getDeviceTypeId()));
        }
        predicates.add(qb.equal(customer.get("status"),appender.get("id")));
        if (conditions.getStates()!=null){

                   predicates.add( qb.between(appender.get("states"), conditions.getStates()[0],conditions.getStates()[1]));
       //     predicates.add(qb.equal(customer.get("status"),conditions.getStates()));
        }
        if(conditions.getUserId()!=0) {
            predicates.add(
                    qb.equal(customer.get("ownerId"), conditions.getUserId()));
        }
        //query itself
        cq.select(customer)
                .where(predicates.toArray(new Predicate[]{}));
        //execute query and do something with result
        List<ApplyInfo> applyInfos=em.createQuery(cq).getResultList();
        List<ApplyResponse>  applyResponses=new ArrayList<>();
        for(ApplyInfo applyInfo:applyInfos){
            applyResponses.add(new ApplyResponse(applyInfo));
        }
        return applyResponses;
       // return  em.createQuery(cq).getResultList();
//        Pageable pageable=getPageable(sort);
//        int start = pageable.getOffset();
//        int end = (start + pageable.getPageSize()) > list.size() ? list.size() : (start + pageable.getPageSize());
//        return new CustomePage<ApplyInfo>(list.subList(start,end),getPageable(sort),list.size());

    }

    public ApplySearchCondition(Object conditions) {
        super(conditions);
        this.conditions=(ApplyConditions) conditions;
    }

}
