package com.example.demo.connector.updater;

import java.io.Serializable;

/**
 * @author yang
 * @create_at 17-10-22
 **/
public class ApplyHandler implements Serializable{
    private long  applyId;
    private boolean pass;
    private String reason;
    private String detailReason;

    private String rejectReasons;

    public long getApplyId() {
        return applyId;
    }

    public void setApplyId(long applyId) {
        this.applyId = applyId;
    }





    public String getRejectReasons() {
        return rejectReasons;
    }

    public void setRejectReasons(String rejectReasons) {
        this.rejectReasons = rejectReasons;
    }

    public boolean getPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDetailReason() {
        return detailReason;
    }

    public void setDetailReason(String detailReason) {
        this.detailReason = detailReason;
    }
}
