package com.example.demo.service;

import com.example.demo.entity.data.ApplyInfo;
import com.example.demo.service.exception.NotFoundException;
import org.apache.shiro.session.Session;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author yang
 * @create_at 2017/10/17
 **/
public interface ApplyService {
     ApplyInfo findByApplyID(Long ID,Session session);
     Page<ApplyInfo> findApplyInfosForUser(long user_id, long device_id, long before, long after, Pageable pageable);
     List<ApplyInfo> findByApplierName(String username);
     List<ApplyInfo> findAllApply();
     ApplyInfo createApply(ApplyInfo apply,long userId);
     Page<ApplyInfo> searchForUser(long userId,long deviceTypeId,long start,long end,Pageable pageable);

    Page<ApplyInfo> searchForApprover(long userId,long deviceTypeId,long start,long end,Pageable pageable);
    Page<ApplyInfo> searchForAcceptor(long userId,long deviceTypeId,long start,long end,Pageable pageable);

    void delApply(long applyId,Session session);
    ApplyInfo saveApply(ApplyInfo applyInfo, Session session);
    void confirmApply(long applyId,Session session)throws Exception;
    ApplyInfo cancelApply(long applyId,Session session);
    ApplyInfo updateForm(ApplyInfo applyInfo,Session session);
    ApplyInfo updateApply(MultipartFile file,long applyId,Session session)throws Exception;
    ApplyInfo findApplyByEqCode(String code,Session session);
    ApplyInfo sendRegist(long applyId,Session session);
    ApplyInfo addDevices(MultipartFile file, long applyId, Session session);
}
