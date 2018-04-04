package com.example.demo.enums;

import com.example.demo.entity.device.DeviceType;

public enum DeviceTypeEnum {
    NULL(""),锅炉("锅"),压力容器("容"),电梯("梯"),起重机械("起"),客运索道("索"),大型游乐设施("游"),厂内专用机动车辆("车"),车用气瓶("瓶"),普通气瓶("瓶"),工业管道("管"),其他("他");
    private String shortName;
    private DeviceTypeEnum(String str){
       this.shortName=str;
    }

    public String getShortName() {
        return shortName;
    }
}