package com.example.demo.Dao.apply;

import com.example.demo.entity.dataModel.ApplyInfo;
import com.example.demo.entity.dataModel.ApplyStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import java.util.List;
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
    //@Query(value = "select u from ApplyInfo u")
    //public Stream<ApplyInfo> findAllBy(Stream<ApplyInfo> applyInfoStream);

}
