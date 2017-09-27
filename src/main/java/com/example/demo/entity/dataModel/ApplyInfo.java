package com.example.demo.entity.dataModel;

import com.example.demo.entity.formModel.*;
import com.example.demo.service.view.View;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplyInfo  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.ApplyForView.class)
    private long id;
    private String codeId;
    @JsonView(View.ApplyForView.class)
    private int  applyTypeId;
    @JsonView(View.ApplyForView.class)
    private long deviceId;

    private long approverAgencyId;
    private long acceptorAgencyId;
    private long ownerId;
    @JsonView(View.ApplyForView.class)
    private int address;
    private boolean hasFile=true;
    @JsonView(View.ApplyForView.class)
    private long createTime;
    @JsonView(View.ApplyForView.class)
    private int deviceTypeId;
    private String filesId;
    @OneToOne(cascade = CascadeType.ALL)
    private ApplyStatus applyStatus;
    @OneToOne(cascade = CascadeType.ALL)
    private Form1 form1;
    @OneToOne(cascade = CascadeType.ALL)
    private Form2 form2;
    @OneToOne(cascade = CascadeType.ALL)
    private Form3 form3;
    @OneToOne(cascade = CascadeType.ALL)
    private Form4 form4;
    @OneToOne(cascade = CascadeType.ALL)
    private Form5 form5;
    @OneToOne(cascade = CascadeType.ALL)
    private Form6 form6;
    @OneToOne(cascade = CascadeType.ALL)
    private Form7 form7;
    @OneToOne(cascade = CascadeType.ALL)
    private Form8 form8;



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


    public int getApplyTypeId() {
        return applyTypeId;
    }

    public void setApplyTypeId(int applyTypeId) {
        this.applyTypeId = applyTypeId;
    }

    public ApplyStatus getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(ApplyStatus applyStatus) {
        this.applyStatus = applyStatus;
    }

    public Form1 getForm1() {
        return form1;
    }

    public void setForm1(Form1 form1) {
        this.form1 = form1;
    }

    public Form2 getForm2() {
        return form2;
    }

    public void setForm2(Form2 form2) {
        this.form2 = form2;
    }

    public Form3 getForm3() {
        return form3;
    }

    public void setForm3(Form3 form3) {
        this.form3 = form3;
    }

    public Form4 getForm4() {
        return form4;
    }

    public void setForm4(Form4 form4) {
        this.form4 = form4;
    }

    public Form5 getForm5() {
        return form5;
    }

    public void setForm5(Form5 form5) {
        this.form5 = form5;
    }

    public Form6 getForm6() {
        return form6;
    }

    public void setForm6(Form6 form6) {
        this.form6 = form6;
    }

    public Form7 getForm7() {
        return form7;
    }

    public void setForm7(Form7 form7) {
        this.form7 = form7;
    }

    public Form8 getForm8() {
        return form8;
    }

    public void setForm8(Form8 form8) {
        this.form8 = form8;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public long getApproverAgencyId() {
        return approverAgencyId;
    }

    public void setApproverAgencyId(long approverAgencyId) {
        this.approverAgencyId = approverAgencyId;
    }

    public long getAcceptorAgencyId() {
        return acceptorAgencyId;
    }

    public void setAcceptorAgencyId(long acceptorAgencyId) {
        this.acceptorAgencyId = acceptorAgencyId;
    }
}
