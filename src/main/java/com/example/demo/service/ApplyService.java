package com.example.demo.service;

import com.example.demo.entity.dataModel.ApplyInfo;
import com.example.demo.entity.dataModel.ApplyStatus;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by yang on 2017/7/27.
 */
public interface ApplyService {
     ApplyInfo findByApplyID(Long ID,Session session);
     Page<ApplyInfo> findApplyInfosForUser(long user_id, long device_id, long before, long after, Pageable pageable);
     List<ApplyInfo> findByApplierName(String username);
     List<ApplyInfo> findAllApply();
     void createApply(ApplyInfo apply,long userId);
     Page<ApplyInfo> searchForUser(long userId,long deviceTypeId,long start,long end,Pageable pageable);

    Page<ApplyInfo> searchForApprover(long userId,long deviceTypeId,long start,long end,Pageable pageable);
    Page<ApplyInfo> searchForAcceptor(long userId,long deviceTypeId,long start,long end,Pageable pageable);

    void delApply(long applyId,Session session);
    void saveApply(ApplyInfo applyInfo, Session session);
    void confirmApply(long applyId,Session session)throws Exception;

}
