package com.example.demo.service.aop;

import com.example.demo.config.annotation.AddCount;
import com.example.demo.config.annotation.InfoMsg;
import com.example.demo.entity.data.ApplyInfo;
import com.example.demo.entity.device.DeviceInfo;
import com.example.demo.enums.DeviceTypeEnum;
import com.example.demo.enums.MsgType;
import com.example.demo.service.RedisService;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 *@author yang
 *@create_at 17-11-10
 **/
@Aspect
@Component
public class Counter {
    @Autowired
    private RedisService redisService;
@Pointcut("@annotation(com.example.demo.config.annotation.AddCount)")
    public void serviceAspect(){

}
@AfterReturning(returning = "ret",pointcut = "serviceAspect()")
public void add(DeviceInfo ret){
    DeviceTypeEnum deviceTypeEnum=ret.getDeviceType();
    redisService.incr(deviceTypeEnum.toString());
}
    public static MsgType getDeviceEnum(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        MsgType countType=MsgType.NULL ;
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);

        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    countType = method.getAnnotation(InfoMsg.class).msgType();
                    break;
                }
            }
        }
        return countType;
    }
}
