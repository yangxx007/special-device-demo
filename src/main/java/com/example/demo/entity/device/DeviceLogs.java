package com.example.demo.entity.device;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class DeviceLogs implements Serializable{
    @Id
    @GeneratedValue
    private Long id;

    private String apply_info_logs;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "device_id")
    private DeviceStatus device;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DeviceStatus getDevice() {
        return device;
    }

    public void setDevice(DeviceStatus device) {
        this.device = device;
    }
    public String getApply_info_logs() {
        return apply_info_logs;
    }

    public void setApply_info_logs(String apply_info_logs) {
        this.apply_info_logs = apply_info_logs;
    }
}
