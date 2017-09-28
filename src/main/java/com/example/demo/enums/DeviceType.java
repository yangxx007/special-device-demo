package com.example.demo.enums;

public enum DeviceType {
    BOILER("锅炉",1),PRESSURE("压力容器",2),ELEVATOR("电梯",3),HOISTING("起重机械",4),CABLEWAY("客运索道",5)
    ,PLAY("大型游乐设施",6),FACTORYCAR("厂内专用机动车辆",7),CARBOX("车用气瓶",8),CYLINDERS("普通气瓶",9),
    PIPELINE("工业管道",10);

    private String name;
    private int index;

    // 构造方法
    DeviceType(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static String getName(int index) {
        for (DeviceType c : DeviceType.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}