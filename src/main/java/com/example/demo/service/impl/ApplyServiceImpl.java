package com.example.demo.service.impl;

import com.example.demo.Dao.apply.ApplyInfoDao;
import com.example.demo.Dao.apply.ApplyInfoSpecification;
import com.example.demo.config.annotation.CacheDuration;
import com.example.demo.entity.dataModel.ApplyInfo;
import com.example.demo.entity.dataModel.ApplyStatus;

import com.example.demo.service.ApplyService;
import com.example.demo.service.UserStatusService;
import com.example.demo.service.ValidateService;
import com.example.demo.service.exception.NotFoundException;

import com.example.demo.service.staticfunction.VerifyUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * Created by yang on 2017/7/26.
 */
@Service
public class ApplyServiceImpl implements ApplyService{
    @Autowired
    private ApplyInfoDao applyDao;
    @Autowired
    private ValidateService validateService;
    @Autowired
    private UserStatusService statusService;

    @Override
    //@Cacheable(value = "apply",key = "#applyId.toString()+#session.getId()")
   // @CacheDuration(duration = 60L)
    public ApplyInfo findByApplyID(Long applyId,Session session) throws NotFoundException {
        System.out.println("信息："+session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));
        ApplyInfo applyInfo=applyDao.findApplyInfoById(applyId);
      //  validateService.isPermission(session,applyInfo);
        return applyInfo;
    }

    @Override
    public Page<ApplyInfo> findApplyInfosForUser(long user_id, long device_id, long before, long after, Pageable
            pageable) {
        return applyDao.findAllByOwnerIdAndDeviceIdAndCreateTimeIsBetween(user_id,device_id,before,after,pageable);

    }

    @Override
    public List<ApplyInfo> findByApplierName(String username) {
        return null;
    }

    @Override
    public List<ApplyInfo> findAllApply() {
        return null;
    }

    @Override
    public void createApply(ApplyInfo apply,long userId) {
        apply.setId(0);
        apply.setOwnerId(userId);
        applyDao.save(apply);
    }

    @Override
    public Page<ApplyInfo> searchForUser(long userId,long deviceTypeId,long start,long end,Pageable pageable) {
        return applyDao.findAll(ApplyInfoSpecification.mixSearchApply(ApplyInfoSpecification.USER,userId,deviceTypeId,
                start,end),pageable);

    }
    @Override
    public Page<ApplyInfo> searchForApprover(long userId,long deviceTypeId,long start,long end,Pageable pageable) {
        return applyDao.findAll(ApplyInfoSpecification.mixSearchApply(ApplyInfoSpecification.APPROVER,userId,deviceTypeId,
                start,end),pageable);

    }
    @Override
    public Page<ApplyInfo> searchForAcceptor(long userId,long deviceTypeId,long start,long end,Pageable pageable) {
        return applyDao.findAll(ApplyInfoSpecification.mixSearchApply(ApplyInfoSpecification.ACCEPTOR,userId,
                deviceTypeId,start,end),pageable);

    }
    @Override
    //@CacheEvict(value="apply",key = "#applyId+#session.getId()")
    public void delApply(long applyId,Session session) {
        applyDao.delete(findByApplyID(applyId,session));
    }

    @Override
    //@CachePut(value = "apply",key="#applyInfo.getId()+#session.getId()")
    public void saveApply(ApplyInfo applyInfo, Session session) {

        validateService.isPermission(session,applyInfo);
        applyInfo.setOwnerId(statusService.getCurrUserId(session));
        applyDao.save(applyInfo);
    }

    @Override
    public void confirmApply(long applyId, Session session)throws Exception  {
        ApplyInfo applyInfo=findByApplyID(applyId,session);
        VerifyUtil.verifyApply(null,applyInfo);
        //System.out.println(applyInfo.getClass().getDeclaredFields()[1].getName());

    }


}
