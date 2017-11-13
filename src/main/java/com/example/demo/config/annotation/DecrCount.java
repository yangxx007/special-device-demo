package com.example.demo.config.annotation;

import com.example.demo.enums.DeviceTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yang
 * @create_at 17-11-10
 **/

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface DecrCount {
    DeviceTypeEnum countType() default DeviceTypeEnum.NULL;
}
