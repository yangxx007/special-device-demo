package com.example.demo.Dao.apply;

import com.example.demo.entity.dataModel.ApplyInfo;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ApplyInfoSpecification {
    public static Specification<ApplyInfo> typeOfApplyInfo(long TypeId,long start,long end){
            return  new Specification<ApplyInfo>() {
                @Override
                public Predicate toPredicate(Root<ApplyInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                    if (TypeId!=0)
                    return cb.and(cb.between(root.get("createTime"),start,end),cb.equal(root.get
                                    ("deviceTypeId"),
                            TypeId));
                    else
                        return cb.between(root.get("createTime"),start,end);
                }
            };

    }

}
