package com.example.demo.service.aop;

import com.example.demo.config.annotation.InfoMsg;
import com.example.demo.dao.apply.ApplyInfoDao;
import com.example.demo.dao.device.DeviceDao;
import com.example.demo.dao.msg.MessageDao;
import com.example.demo.entity.data.ApplyInfo;
import com.example.demo.entity.data.Message;
import com.example.demo.entity.device.DeviceInfo;
import com.example.demo.enums.MsgConstants;
import com.example.demo.enums.MsgType;
import com.example.demo.enums.ReminderTypeEnum;
import com.example.demo.service.utils.UtilServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author yang
 * @create_at 17-11-21
 **/
@Aspect
@Component
public class MsgAspect {
    @Autowired
    private MessageDao messageDao;
    private ReminderTypeEnum msgType;
    private String content;
    @Pointcut("@annotation(com.example.demo.config.annotation.InfoMsg)")
    public void serviceAspect(){
            }

    @AfterReturning(returning ="ret",pointcut ="serviceAspect()" )
    public void saveMsg(ApplyInfo ret){
        Message message =new Message();
        message.setContent(generateContent(content));
        message.setDetailUrl(ret.getId()+"");
        message.setOwnerId(ret.getOwnerId());
        message.setMsgType(MsgType.reminder);
        message.setCreateTime(UtilServiceImpl.date2String(new Date(),"yyyy-MM-dd"));
        messageDao.save(message);
        //applyInfoDao.save(new ApplyInfo());
    }
    public  String generateContent(String message){
        switch (msgType){
            case NULL:
                break;
            case 申请通过审批:
                return MsgConstants.APPLY_PASS_MSG;
            case 申请审批驳回:
                return MsgConstants.APPLY_REFUSE_MSG;
            case 申请受理驳回:
                return MsgConstants.APPLY_REFUSE_MSG;
            case 已发证:
                return MsgConstants.APPLY_REGIST_MSG;
            default:
                break;
        }
        return null;
    }
    @Before("serviceAspect()&&@annotation(infoMsg)")
    public void getDeviceEnum(JoinPoint joinPoint,InfoMsg infoMsg){
            System.out.println(infoMsg.msgType().toString()+infoMsg.content());
            this.msgType=infoMsg.msgType();
            this.content=infoMsg.content();
    }
//    public void  getDeviceEnum(JoinPoint joinPoint)
//            throws Exception {
//        String targetName = joinPoint.getTarget().getClass().getName();
//        String methodName = joinPoint.getSignature().getName();
//        MsgType countType=MsgType.NULL;
//        Object[] arguments = joinPoint.getArgs();
//        Class targetClass = Class.forName(targetName);
//
//        Method[] methods = targetClass.getMethods();
//        for (Method method : methods) {
//            if (method.getName().equals(methodName)) {
//                Class[] clazzs = method.getParameterTypes();
//                if (clazzs.length == arguments.length) {
//                    countType = method.getAnnotation(InfoMsg.class).msgType();
//                    break;
//                }
//            }
//        }
//        this.msgType=countType;
//    }
}
