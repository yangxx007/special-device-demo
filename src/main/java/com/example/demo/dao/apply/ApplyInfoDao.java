package com.example.demo.dao.apply;

import com.example.demo.entity.data.ApplyInfo;
import com.example.demo.entity.data.ApplyStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.domain.Pageable;

import java.util.stream.Stream;

/**
 * Created by yang on 2017/8/10.
 */
public interface ApplyInfoDao extends PagingAndSortingRepository<ApplyInfo,Integer>,
        JpaSpecificationExecutor<ApplyInfo> {

     ApplyInfo findApplyInfoById(Long id);
     Page<ApplyInfo> findAllByOwnerIdAndDeviceIdAndCreateTimeIsBetween(long Owner_id, long
            device_id, long before, long after, Pageable pageable);
     Stream<ApplyInfo> findAllByOwnerId(long id);
     @Query(value = "select u from ApplyStatus u where applyInfo_id=?1 ")
     ApplyStatus findApplyStatusByapplyInfoId(long id);
     @Query(value = "select u from ApplyInfo u left join fetch u.formList uu where u.eqCode=?1")
     ApplyInfo findapplybyeqcode(String eqCode);
    //@Query(value = "select u from ApplyInfo u")
    //public Stream<ApplyInfo> findAllBy(Stream<ApplyInfo> applyInfoStream);

}
