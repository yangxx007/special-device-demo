package com.example.demo.entity.dataModel;



import com.example.demo.Dao.user.UserDao;
import com.example.demo.entity.formModel.*;
import com.example.demo.enums.ApplyTypeEnum;
import com.example.demo.enums.DeviceTypeEnum;
import com.example.demo.enums.FileTypeEnum;

import com.example.demo.service.view.View;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Entity
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplyInfo  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.ApplyForView.class)
    private long id;
    private String codeId;
    @JsonView(View.ApplyForView.class)
    private ApplyTypeEnum  applyType;
    @JsonView(View.ApplyForView.class)
    private long deviceId=0;
   // private ApplyDetailType applyDetailType;
//    @JsonView(View.ApplyForView.class)
//    private int approverAgencyId;
//    @JsonView(View.ApplyForView.class)
//    private String approverAgencyName;
    @JsonView(View.ApplyForView.class)
    private int acceptorAgencyId;
    @JsonView(View.ApplyForView.class)
    private String acceptorAgencyName;
    private long ownerId;
    @JsonView(View.ApplyForView.class)
    private int addressId;
    @JsonView(View.ApplyForView.class)
    private String addressName;
    private boolean hasFile=true;
    @JsonView(View.ApplyForView.class)
    private long createTime;
    @JsonView(View.ApplyForView.class)
    private DeviceTypeEnum deviceType;
    @ElementCollection(fetch = FetchType.EAGER)
    private Map<FileTypeEnum,Long> files=new HashMap<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JsonView(View.ApplyForView.class)
    private ApplyStatus status;
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


//    public ApplyStatus getApplyStatus() {
//        return applyStatus;
//    }
//
//    public void setApplyStatus(ApplyStatus applyStatus) {
//        this.applyStatus = applyStatus;
//    }

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



//    public int getApproverAgencyId() {
//        return approverAgencyId;
//    }

//    public void setApproverAgencyId(int approverAgencyId) {
//        this.approverAgencyId = approverAgencyId;
//    }

    public int getAcceptorAgencyId() {
        return acceptorAgencyId;
    }

    public void setAcceptorAgencyId(int acceptorAgencyId) {
        this.acceptorAgencyId = acceptorAgencyId;
    }


    public Map<FileTypeEnum, Long> getFiles() {
        return files;
    }

    public void setFiles(Map<FileTypeEnum, Long> files) {
        this.files = files;
    }

    public ApplyTypeEnum getApplyType() {
        return applyType;
    }

    public void setApplyType(ApplyTypeEnum applyType) {
        this.applyType = applyType;
    }


    public DeviceTypeEnum getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceTypeEnum deviceType) {
        this.deviceType = deviceType;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

//    public String getApproverAgencyName() {
//        return approverAgencyName;
//    }

//    public void setApproverAgencyName(String approverAgencyName) {
//        this.approverAgencyName = approverAgencyName;
//    }

    public String getAcceptorAgencyName() {
        return acceptorAgencyName;
    }

    public void setAcceptorAgencyName(String acceptorAgencyName) {
        this.acceptorAgencyName = acceptorAgencyName;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
//        this.addressName="津港区技术监督局";
        this.addressId = addressId;

        //this.addressName=userDao.findByUid(2).getUsername();


    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public ApplyStatus getStatus() {
        return status;
    }

    public void setStatus(ApplyStatus status) {
        this.status = status;
    }
}
