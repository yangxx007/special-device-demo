package com.example.demo.config.annotation;

import com.example.demo.enums.MsgType;
import com.example.demo.enums.ReminderTypeEnum;

import java.lang.annotation.*;

/**
 * @author yang
 * @create_at 17-11-21
 **/
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InfoMsg {
    /**
     * 日志操作描述
     * @return
     */
    String content() default "";
    ReminderTypeEnum msgType() default ReminderTypeEnum.NULL;
}