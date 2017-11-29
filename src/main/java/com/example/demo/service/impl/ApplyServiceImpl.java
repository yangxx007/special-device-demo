package com.example.demo.service.impl;

import com.example.demo.config.annotation.InfoMsg;
import com.example.demo.dao.apply.ApplyInfoDao;
import com.example.demo.dao.apply.ApplyInfoSpecification;
import com.example.demo.entity.data.ApplyInfo;

import com.example.demo.entity.device.DeviceInfo;
import com.example.demo.entity.form.Form;
import com.example.demo.entity.form.SubForm;
import com.example.demo.enums.*;
import com.example.demo.service.*;
import com.example.demo.service.exception.NotFoundException;

import com.example.demo.service.exception.ValidateFailException;
import com.example.demo.service.utils.FileUtil;
import com.example.demo.service.utils.UtilServiceImpl;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
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
    private FileService fileService;
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private UserStatusService statusService;

    @Override
    //@Cacheable(value = "apply",key = "#applyId.toString()+#session.getId()")
   // @CacheDuration(duration = 60L)
    public ApplyInfo findByApplyID(Long applyId,Session session) throws NotFoundException {
        System.out.println("信息："+session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));
        return applyDao.findApplyInfoById(applyId);
       //validateService.isPermission(session,applyInfo);

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
        if(apply.getDeviceId()!=0){
            deviceService.device2Apply(apply.getDeviceId(),apply);
        }
        Map<FormTypeEnum,Long> map=apply.getForms();
        if(fileService.createPdf(apply)!=null){
        map.putAll(fileService.createPdf(apply));
        }
        return applyDao.save(apply);
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
            DeviceInfo deviceInfo=deviceService.getDeviceById(applyInfo.getDeviceId(),session);
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
            DeviceInfo deviceInfo=deviceService.getDeviceById(applyInfo.getDeviceId(),session);
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
        return applyDao.save(applyInfo);
    }
    @Override
    //@CachePut(value = "apply",key="#applyInfo.getId()+#session.getId()")
    public ApplyInfo updateForm(ApplyInfo applyInfo, Session session) {
        validateService.isPermission(session,applyInfo);
        Map<FormTypeEnum,Long> map=applyInfo.getForms();
        map.putAll(fileService.createPdf(applyInfo));
        return applyDao.save(applyInfo);
    }
    @Transactional
    @Override
    public ApplyInfo updateApply(MultipartFile file, long applyId,Session session)throws Exception {
        ApplyInfo applyInfo =findByApplyID(applyId,session);
        FileUtil fileUtil=new FileUtil(file);
        List<Form> forms=applyInfo.getFormList();
        Form form=forms.get(0);
        if(form.getFormType()==FormTypeEnum.特种设备使用登记表三&&forms.size()==1){
           switch (applyInfo.getDeviceType()){
               case 工业管道:
                   form=createForm(form);
                   form.setFormType(FormTypeEnum.压力管道基本信息汇总表);
                   forms.add(form);
                   break;
               case 普通气瓶:
                   form=createForm(form);
                   form.setFormType(FormTypeEnum.气瓶基本信息汇总表);
                   forms.add(form);
                   break;
               default:
                   break;
           }

        }
        for(Form subform:forms){
            if(subform.getFormType()== FormTypeEnum.气瓶基本信息汇总表)
            {   List<SubForm> subForms=subform.getSubList();
            if(subForms!=null) {
                subForms.addAll(fileUtil.excel2lists(statusService.getCurrUserId(session)));
            }else{
                subform.setSubList(fileUtil.excel2lists(statusService.getCurrUserId(session)));
            }
            }
            if(subform.getFormType()==FormTypeEnum.压力管道基本信息汇总表){
                List<SubForm> subForms=subform.getSubList();
                if(subForms!=null) {
                    subForms.addAll(fileUtil.excel2lists(statusService.getCurrUserId(session)));
                }else{
                    subform.setSubList(fileUtil.excel2lists(statusService.getCurrUserId(session)));
                }
            }

        }
       return updateForm(applyInfo,session);
    }

    private Form createForm(Form form) throws Exception{
        Form form1=new Form();
        form1.setFormCreateDate(new Date());
        form1.setComTablePerson(form.getComTablePerson());
        form1.setSuperviseComName(form.getSuperviseComName());
        form1.setEmail(form.getEmail());
        form1.setUseComAddr(form.getUseComAddr());
        form1.setUseComName(form.getUseComName());
        form1.setSafeAdministrator(form.getSafeAdministrator());
        form1.setMobilePhone(form.getMobilePhone());
        return form1;
    }
    @Transactional
    @Override
    public ApplyInfo findApplyByEqCode(String code,Session session) {
        ApplyInfo applyInfo= applyDao.findFirstByEqCode(code);
        validateService.isPermission(session,applyInfo);
        return applyInfo;
    }

    @Override
    public ApplyInfo addDevices(MultipartFile file, long applyId, Session session) {
        return null;
    }

    @Override
    public void confirmApply(long applyId, Session session)throws Exception  {
        ApplyInfo applyInfo=findByApplyID(applyId,session);

        if(applyInfo.getDeviceId()!=0&&applyInfo.getApplyType()!= ApplyTypeEnum.首次申请)
        {   List<DeviceInfo> deviceInfos=new ArrayList<>();
            if(applyInfo.getDeviceList()!=null&&applyInfo.getDeviceList().length!=0){
                for(long id:applyInfo.getDeviceList()){
                    deviceInfos.add(deviceService.getDeviceById(id,session));
                }
            }else
            {
                deviceInfos.add(deviceService.getDeviceById(applyInfo.getDeviceId(),session));
            }
            for(DeviceInfo deviceInfo:deviceInfos){
            deviceInfo.processing(applyId);
            deviceService.save(deviceInfo);
            }
        }
        applyInfo.getStatus().setStates(ApplyStatesEnum.已提交待受理);
        applyInfo.getStatus().setApplyDate(UtilServiceImpl.getLongCurrTime());
        saveApply(applyInfo,session);
        //VerifyUtil.verifyApply(null,applyInfo);
        //System.out.println(applyInfo.getClass().getDeclaredFields()[1].getName());

    }
//    public boolean canOperate(ApplyInfo applyInfo){
//        return  ApplyStatesEnum.已受理待审批.compareTo(applyInfo.getStatus().getStates())>0;
//    }

}
