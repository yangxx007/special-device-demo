package com.example.demo.connector.responser;


import com.example.demo.entity.data.ApplyInfo;
import com.example.demo.entity.data.ApplyStatus;
import com.example.demo.enums.ApplyStatesEnum;
import com.example.demo.service.utils.UtilServiceImpl;

import java.io.Serializable;

/**
 * @author yang
 * @create_at 17-11-2
 **/
public class WorkFlowInfo implements Serializable{
    private ApplyInfo applyInfo;
    private ApplyStatus status;
    public WorkFlowInfo(ApplyInfo applyInfo){
        this.applyInfo=applyInfo;
        status=applyInfo.getStatus();
    }
    public long getId(){return applyInfo.getId();}

    public long getApplyDate() {
        return status.getApplyDate();
    }


    public ApplyStatesEnum getStates() {
        return status.getStates();
    }


    public String getRejectReasons() {
        return status.getRejectReasons();
    }


    public String getAcceptorName() {
        return status.getAcceptorName();
    }


    public String getApproverName() {
        return status.getApproverName();
    }


    public String getAcceptTellDate()throws Exception {
        return UtilServiceImpl.long2String(status.getAcceptTellDate(),"yyyy年MM月dd日");
    }


    public String getUnAcceptTellDate()throws Exception {
        return UtilServiceImpl.long2String(status.getUnAcceptTellDate(),"yyyy年MM月dd日") ;
    }


    public String getApprovalDate() throws Exception{
        return UtilServiceImpl.long2String(status.getApprovalDate(),"yyyy年MM月dd日");
    }


    public String getUnApprovalDate()throws Exception {
        return UtilServiceImpl.long2String(status.getUnApprovalDate(),"yyyy年MM月dd日");
    }


    public String getUnAcceptedReason() {
        return status.getUnAcceptedReason();
    }


    public String getUnApprovalReason() {
        return status.getUnApprovalReason();
    }


    public String getApplyAcceptDate() throws Exception{
        return UtilServiceImpl.long2String(status.getApplyAcceptDate(),"yyyy年MM月dd日");
    }


    public String getUnAcceptedDetailReason() {
        return status.getUnAcceptedDetailReason();
    }


    public String getUnApprovalDetailReason() {
        return status.getUnApprovalDetailReason();
    }

    public String getDeviceCategory(){return applyInfo.getDeviceCategory();}
    public String getEqCode(){return applyInfo.getEqCode();}
    public String getComCode(){return  applyInfo.getComCode();}
    public String getAcceptorAgencyName(){return applyInfo.getAcceptorAgencyName();}
    public String getRegistCode(){return applyInfo.getRegistCode();}
}
