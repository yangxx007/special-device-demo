package com.example.demo.entity.data;



import com.example.demo.enums.ApplyStatesEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplyStatus implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private ApplyStatesEnum states=ApplyStatesEnum.未提交;
    private String unAcceptedDetailReason;
    private String unApprovalDetailReason;
    private long acceptTellDate;
    private long unAcceptTellDate;
    private long approvalDate;
    private long unApprovalDate;
    private String unAcceptedReason;
    private String unApprovalReason;
    /**submit apply time* */
    private long applyDate;
    private long applyAcceptDate;
    private String acceptorName;
    private String approverName;
    private String rejectReasons;

    public long getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(long applyDate) {
        this.applyDate = applyDate;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ApplyStatesEnum getStates() {
        return states;
    }

    public void setStates(ApplyStatesEnum states) {
        this.states = states;
    }

    public String getRejectReasons() {
        return rejectReasons;
    }

    public void setRejectReasons(String rejectReasons) {
        this.rejectReasons = rejectReasons;
    }

    public String getAcceptorName() {
        return acceptorName;
    }

    public void setAcceptorName(String acceptorName) {
        this.acceptorName = acceptorName;
    }

    public String getApproverName() {
        return approverName;
    }

    public void setApproverName(String approverName) {
        this.approverName = approverName;
    }

    public long getAcceptTellDate() {
        return acceptTellDate;
    }

    public void setAcceptTellDate(long acceptTellDate) {
        this.acceptTellDate = acceptTellDate;
    }

    public long getUnAcceptTellDate() {
        return unAcceptTellDate;
    }

    public void setUnAcceptTellDate(long unAcceptTellDate) {
        this.unAcceptTellDate = unAcceptTellDate;
    }

    public long getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(long approvalDate) {
        this.approvalDate = approvalDate;
    }

    public long getUnApprovalDate() {
        return unApprovalDate;
    }

    public void setUnApprovalDate(long unApprovalDate) {
        this.unApprovalDate = unApprovalDate;
    }

    public String getUnAcceptedReason() {
        return unAcceptedReason;
    }

    public void setUnAcceptedReason(String unAcceptedReason) {
        this.unAcceptedReason = unAcceptedReason;
    }

    public String getUnApprovalReason() {
        return unApprovalReason;
    }

    public void setUnApprovalReason(String unApprovalReason) {
        this.unApprovalReason = unApprovalReason;
    }

    public long getApplyAcceptDate() {
        return applyAcceptDate;
    }

    public void setApplyAcceptDate(long applyAcceptDate) {
        this.applyAcceptDate = applyAcceptDate;
    }

    public String getUnAcceptedDetailReason() {
        return unAcceptedDetailReason;
    }

    public void setUnAcceptedDetailReason(String unAcceptedDetailReason) {
        this.unAcceptedDetailReason = unAcceptedDetailReason;
    }

    public String getUnApprovalDetailReason() {
        return unApprovalDetailReason;
    }

    public void setUnApprovalDetailReason(String unApprovalDetailReason) {
        this.unApprovalDetailReason = unApprovalDetailReason;
    }
}
