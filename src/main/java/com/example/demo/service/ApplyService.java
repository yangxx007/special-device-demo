package com.example.demo.service;

import com.example.demo.entity.dataModel.ApplyInfo;
import com.example.demo.entity.dataModel.ApplyStatus;
import org.apache.shiro.subject.Subject;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by yang on 2017/7/27.
 */
public interface ApplyService {
     ApplyInfo findByApplyID(Long ID,Subject subject);
     Page<ApplyInfo> findApplyInfosForUser(long user_id, long device_id, long before, long after, Pageable pageable);
     List<ApplyStatus> findByApplierName(String username);
     List<ApplyStatus> findAllApply();
     void createApply(ApplyInfo apply,long userId);
     Page<ApplyInfo> searchForUser(long userId,long deviceTypeId,long start,long end,Pageable pageable);
     ApplyStatus findApplyStatusByApplyId(long apply_id);
    Page<ApplyInfo> searchForApprover(long userId,long deviceTypeId,long start,long end,Pageable pageable);
    Page<ApplyInfo> searchForAcceptor(long userId,long deviceTypeId,long start,long end,Pageable pageable);

    void delApply(long applyId,Subject subject);
    void saveApply(ApplyInfo applyInfo, Subject subject);
    void confirmApply(long applyId,Subject subject)throws Exception;

}
