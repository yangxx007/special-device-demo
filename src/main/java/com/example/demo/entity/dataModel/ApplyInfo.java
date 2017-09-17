package com.example.demo.entity.dataModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ApplyInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String codeId;
    private int  applyTypeId;
    private long deviceId;
    private long acceptorAdminstrationId;
    private long auditorAdminstrationId;
    private long ownerId;
    private boolean hasFile=true;
    private long createTime;
    private String action;
    private int deviceTypeId;
    private String filesId;
    private Long apply1;
    private Long apply2;
    private Long apply3;
    private Long apply4;
    private Long apply5;
    private Long apply6;
    private Long apply7;
    private Long apply8;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public long getAcceptorAdminstrationId() {
        return acceptorAdminstrationId;
    }

    public void setAcceptorAdminstrationId(long acceptorAdminstrationId) {
        this.acceptorAdminstrationId = acceptorAdminstrationId;
    }

    public long getAuditorAdminstrationId() {
        return auditorAdminstrationId;
    }

    public void setAuditorAdminstrationId(long auditorAdminstrationId) {
        this.auditorAdminstrationId = auditorAdminstrationId;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public boolean isHasFile() {
        return hasFile;
    }

    public void setHasFile(boolean hasFile) {
        this.hasFile = hasFile;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(int deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getFilesId() {
        return filesId;
    }

    public void setFilesId(String filesId) {
        this.filesId = filesId;
    }

    public Long getApply1() {
        return apply1;
    }

    public void setApply1(Long apply1) {
        this.apply1 = apply1;
    }

    public Long getApply2() {
        return apply2;
    }

    public void setApply2(Long apply2) {
        this.apply2 = apply2;
    }

    public Long getApply3() {
        return apply3;
    }

    public void setApply3(Long apply3) {
        this.apply3 = apply3;
    }

    public Long getApply4() {
        return apply4;
    }

    public void setApply4(Long apply4) {
        this.apply4 = apply4;
    }

    public Long getApply5() {
        return apply5;
    }

    public void setApply5(Long apply5) {
        this.apply5 = apply5;
    }

    public Long getApply6() {
        return apply6;
    }

    public void setApply6(Long apply6) {
        this.apply6 = apply6;
    }

    public Long getApply7() {
        return apply7;
    }

    public void setApply7(Long apply7) {
        this.apply7 = apply7;
    }

    public Long getApply8() {
        return apply8;
    }

    public void setApply8(Long apply8) {
        this.apply8 = apply8;
    }
}
