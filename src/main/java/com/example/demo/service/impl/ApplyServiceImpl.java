package com.example.demo.service.impl;

import com.example.demo.dao.apply.ApplyInfoDao;
import com.example.demo.dao.apply.ApplyInfoSpecification;
import com.example.demo.entity.data.ApplyInfo;

import com.example.demo.entity.device.DeviceInfo;
import com.example.demo.enums.ApplyStatesEnum;
import com.example.demo.enums.ApplyTypeEnum;
import com.example.demo.enums.FormTypeEnum;
import com.example.demo.service.*;
import com.example.demo.service.exception.NotFoundException;

import com.example.demo.service.exception.ValidateFailException;
import org.apache.bcel.verifier.exc.VerificationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;


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
    @Autowired
    private FileService fileService;
    @Autowired
    private DeviceService deviceService;

    @Override
    //@Cacheable(value = "apply",key = "#applyId.toString()+#session.getId()")
   // @CacheDuration(duration = 60L)
    public ApplyInfo findByApplyID(Long applyId,Session session) throws NotFoundException {
        System.out.println("信息："+session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));
        ApplyInfo applyInfo=applyDao.findApplyInfoById(applyId);
       //validateService.isPermission(session,applyInfo);
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
    public ApplyInfo createApply(ApplyInfo apply,long userId) {
        apply.setId(0);
        apply.setOwnerId(userId);
        ApplyInfo applyInfo= applyDao.save(apply);
        Map<FormTypeEnum,Long> map=applyInfo.getForms();
        map.putAll(fileService.createPdf(applyInfo));
        return applyDao.save(applyInfo);
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
        ApplyInfo applyInfo=findByApplyID(applyId,session);
        if(applyInfo.getDeviceId()!=0&&applyInfo.getApplyType()!= ApplyTypeEnum.首次申请)
        {
            DeviceInfo deviceInfo=deviceService.getDeviceById(applyInfo.getDeviceId());
            deviceInfo.endprocessing();
            deviceService.save(deviceInfo);
        }
        applyDao.delete(applyInfo);
    }
    @Override
    //@CacheEvict(value="apply",key = "#applyId+#session.getId()")
    public ApplyInfo cancelApply(long applyId,Session session) {
        ApplyInfo applyInfo=findByApplyID(applyId,session);
        if(applyInfo.getStatus().getStates().compareTo(ApplyStatesEnum.已受理待审批)>=0){
            throw new ValidateFailException("you are not allowed to do this operation");
        }
        if(applyInfo.getDeviceId()!=0&&applyInfo.getApplyType()!= ApplyTypeEnum.首次申请)
        {
            DeviceInfo deviceInfo=deviceService.getDeviceById(applyInfo.getDeviceId());
            deviceInfo.endprocessing();
            deviceService.save(deviceInfo);
        }
        applyInfo.getStatus().setStates(ApplyStatesEnum.未提交);
        return saveApply(applyInfo,session);
    }


    @Override
    //@CachePut(value = "apply",key="#applyInfo.getId()+#session.getId()")
    public ApplyInfo saveApply(ApplyInfo applyInfo, Session session) {
        validateService.isPermission(session,applyInfo);
        Map<FormTypeEnum,Long> map=applyInfo.getForms();
        map.putAll(fileService.createPdf(applyInfo));
        return applyDao.save(applyInfo);
    }

    @Override
    public void confirmApply(long applyId, Session session)throws Exception  {
        ApplyInfo applyInfo=findByApplyID(applyId,session);

        if(applyInfo.getDeviceId()!=0&&applyInfo.getApplyType()!= ApplyTypeEnum.首次申请)
        {
            DeviceInfo deviceInfo=deviceService.getDeviceById(applyInfo.getDeviceId());
            deviceInfo.processing(applyId);
            deviceService.save(deviceInfo);
        }
        applyInfo.getStatus().setStates(ApplyStatesEnum.已提交待受理);
        saveApply(applyInfo,session);
        //VerifyUtil.verifyApply(null,applyInfo);
        //System.out.println(applyInfo.getClass().getDeclaredFields()[1].getName());

    }
//    public boolean canOperate(ApplyInfo applyInfo){
//        return  ApplyStatesEnum.已受理待审批.compareTo(applyInfo.getStatus().getStates())>0;
//    }

}
