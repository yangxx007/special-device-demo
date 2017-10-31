package com.example.demo.dao.device;

import com.example.demo.connector.conditions.DeviceConditions;
import com.example.demo.entity.data.ApplyInfo;
import com.example.demo.entity.device.DeviceInfo;
import com.example.demo.service.multiSearch.MultiSearch;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DeviceSearchCondition extends MultiSearch {
   private DeviceConditions conditions;
    @Override
    public List<? extends DeviceInfo> searchByConditions(EntityManager em) throws Exception{

        long[] long_time=conditions.parseTime("yyyy-MM-dd");
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery cq = qb.createQuery();
        Root<ApplyInfo> customer = cq.from(DeviceInfo.class);
        //Constructing list of parameters
        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(qb.between(customer.get("createAt"),long_time[0],long_time[1]));
        //Adding predicates in case of parameter not being null
        if (conditions.getDeviceName() != null) {
            predicates.add(
                    qb.equal(customer.get("deviceName"), conditions.getDeviceName()));
        }
        if (conditions.getDeviceCategory() != null) {
            predicates.add(
                    qb.equal(customer.get("deviceCategory"), conditions.getDeviceCategory()));
        }
        if (conditions.getDeviceClass() != null) {
            predicates.add(
                    qb.equal(customer.get("deviceClass"), conditions.getDeviceClass()));
        }
        if (conditions.getDeviceCode() != null) {
            predicates.add(
                    qb.equal(customer.get("deviceCode"), conditions.getDeviceCode()));
        }
        if (conditions.getDeviceKind() != null) {
            predicates.add(
                    qb.equal(customer.get("deviceKind"), conditions.getDeviceKind()));
        }
        if (conditions.getDeviceTypeId() != 0) {
            predicates.add(
                    qb.equal(customer.get("deviceType"), conditions.getDeviceTypeId()));
        }

        if (conditions.getStates()!=null){

                   predicates.add( qb.between(customer.get("deviceStates"), conditions.getStates()[0],conditions.getStates()[1]));
       //     predicates.add(qb.equal(customer.get("status"),conditions.getStates()));
        }

        if(conditions.getAgencyId()!=0){
            predicates.add(qb.equal(customer.get("agencyId"),conditions.getAgencyId()));
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
        List<DeviceInfo> deviceInfos=em.createQuery(cq).getResultList();
//        List<DeviceResponse>  deviceResponses=new ArrayList<>();
//        for(DeviceInfo deviceInfo:deviceInfos){
//            deviceResponses.add(new DeviceResponse(deviceInfo));
//        }
        return deviceInfos;
       // return  em.createQuery(cq).getResultList();
//        Pageable pageable=getPageable(sort);
//        int start = pageable.getOffset();
//        int end = (start + pageable.getPageSize()) > list.size() ? list.size() : (start + pageable.getPageSize());
//        return new CustomePage<ApplyInfo>(list.subList(start,end),getPageable(sort),list.size());

    }

    public DeviceSearchCondition(DeviceConditions conditions) {
        super(conditions);
        this.conditions= conditions;
    }

}
