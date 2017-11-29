package com.example.demo.dao.apply;

import com.example.demo.connector.conditions.ApplyConditions;
import com.example.demo.connector.responser.ApplyResponse;
import com.example.demo.connector.conditions.SearchConditions;
import com.example.demo.entity.data.ApplyInfo;
import com.example.demo.entity.data.ApplyStatus;
import com.example.demo.connector.responser.WorkFlowInfo;
import com.example.demo.enums.RoleTypeEnum;
import com.example.demo.service.multiSearch.MultiSearch;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ApplySearchCondition extends MultiSearch {
   private ApplyConditions conditions;
    @Override
    public List<ApplyInfo> searchByConditions(EntityManager em) throws Exception{

        long[] long_time=conditions.parseTime("yyyy-MM-dd");
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery cq = qb.createQuery();
        Root<ApplyInfo> customer = cq.from(ApplyInfo.class);
        Root<ApplyStatus> appender=cq.from(ApplyStatus.class);
        //Constructing list of parameters
        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(qb.between(customer.get("createTime"),long_time[0],long_time[1]));
        //Adding predicates in case of parameter not being null
        if(conditions.getEqCode()!=null){
            predicates.add(qb.equal(customer.get("eqCode"), conditions.getEqCode()));
        }
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
            Predicate predicate=qb.equal(appender.get("states"),conditions.getStates()[0]);
            for(int i:conditions.getStates()){
                predicate=qb.or(predicate,qb.equal(appender.get("states"), i));
            }
            predicates.add(predicate);
        }
        if(conditions.getRole()== RoleTypeEnum.受理人员||conditions.getRole()==RoleTypeEnum.审批人员){
            predicates.add(qb.equal(customer.get("processing"),false));
        }
        if(conditions.getAgencyId()!=0){
            predicates.add(qb.equal(customer.get("acceptorAgencyId"),conditions.getAgencyId()));
        }
        else{
            if(conditions.getUserId()!=0) {
            predicates.add(
                    qb.equal(customer.get("ownerId"), conditions.getUserId()));
            }
        }

        //query itself
        cq.select(customer)
                .where(predicates.toArray(new Predicate[]{}));
        //execute query and do something with result
        List<ApplyInfo> applyInfos=em.createQuery(cq).getResultList();

        return applyInfos;
       // return  em.createQuery(cq).getResultList();
//        Pageable pageable=getPageable(sort);
//        int start = pageable.getOffset();
//        int end = (start + pageable.getPageSize()) > list.size() ? list.size() : (start + pageable.getPageSize());
//        return new CustomePage<ApplyInfo>(list.subList(start,end),getPageable(sort),list.size());

    }
    public List<WorkFlowInfo> convert2Workflow(EntityManager em)throws Exception{
        List<ApplyInfo> applyInfos=searchByConditions(em);
        List<WorkFlowInfo>  workFlowInfos=new ArrayList<>();
        for(ApplyInfo applyInfo:applyInfos){
            workFlowInfos.add(new WorkFlowInfo(applyInfo));
        }
        return workFlowInfos;
    }
    public List<ApplyResponse> converter2ApplyResponse(EntityManager em)throws Exception{
        List<ApplyInfo> applyInfos=searchByConditions(em);
        List<ApplyResponse>  applyResponses=new ArrayList<>();
        for(ApplyInfo applyInfo:applyInfos){
            applyResponses.add(new ApplyResponse(applyInfo));
        }
        return applyResponses;
    }
    public ApplySearchCondition(Object conditions) {
        super(conditions);
        this.conditions=(ApplyConditions) conditions;
    }

}
