package com.example.demo.Dao.apply;

import com.example.demo.entity.dataModel.ApplyInfo;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ApplyInfoSpecification {
    public final static int USER=1;
    public final static int APPROVER=2;
    public final static int ACCEPTOR=3;
    public final static int SUPERVISOR=4;
    public static Specification<ApplyInfo> mixSearchApply(int Type,long Id,long deviceTypeId,long start,long end){
            return  new Specification<ApplyInfo>() {
                @Override
                public Predicate toPredicate(Root<ApplyInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                    String attribute;
                    switch (Type){
                        case 1:
                            attribute="ownerId";
                            break;
                        case 2:
                             attribute="approverAgencyId";
                            break;
                        case 3:
                             attribute="acceptorAgencyId";
                            break;
                        default:
                             attribute="ownerId";
                    }
                    if (deviceTypeId!=0)
                    return cb.and(cb.between(root.get("createTime"),start,end),cb.equal(root.get
                                    ("deviceTypeId"),
                            deviceTypeId),cb.equal(root.get(attribute),Id));
                    else
                    return cb.and(cb.between(root.get("createTime"),start,end),cb.equal(root.get(attribute),
                            Id));
                    }

            };

    }


}
