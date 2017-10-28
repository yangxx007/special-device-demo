package com.example.demo.entity.device;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class DeviceAction implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    private Integer action_new;
    private Integer action_alter_company;
    private Integer action_alter_owner;
    private Integer action_movement;
    private Integer action_transform;
    private Integer action_remove;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deviceType_id")
    private DeviceType deviceType;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DeviceType getDevice_type() {
        return deviceType;
    }

    public void setDevice_type(DeviceType device_type) {
        this.deviceType = device_type;
    }
    public Integer getAction_new() {
        return action_new;
    }

    public void setAction_new(Integer action_new) {
        this.action_new = action_new;
    }

    public Integer getAction_alter_company() {
        return action_alter_company;
    }

    public void setAction_alter_company(Integer action_alter_company) {
        this.action_alter_company = action_alter_company;
    }

    public Integer getAction_alter_owner() {
        return action_alter_owner;
    }

    public void setAction_alter_owner(Integer action_alter_owner) {
        this.action_alter_owner = action_alter_owner;
    }

    public Integer getAction_movement() {
        return action_movement;
    }

    public void setAction_movement(Integer action_movement) {
        this.action_movement = action_movement;
    }

    public Integer getAction_transform() {
        return action_transform;
    }

    public void setAction_transform(Integer action_transform) {
        this.action_transform = action_transform;
    }

    public Integer getAction_remove() {
        return action_remove;
    }

    public void setAction_remove(Integer action_remove) {
        this.action_remove = action_remove;
    }
}
