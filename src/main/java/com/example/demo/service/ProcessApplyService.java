package com.example.demo.service;

import com.example.demo.entity.data.ApplyInfo;
import com.example.demo.entity.device.DeviceType;
import org.apache.shiro.session.Session;

/**
 * @Author yang
 * @CREATE_AT 17-10-18
 **/
public interface ProcessApplyService {
   /**accept the apply*/
   void acceptApply(ApplyInfo applyInfo, Session session);
   void approveApply(ApplyInfo applyInfo,Session session);
   void registerDevice(DeviceType deviceType);
   void rejectApply(ApplyInfo applyInfo,Session session);
}
