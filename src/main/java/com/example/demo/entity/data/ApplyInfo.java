package com.example.demo.entity.data;



import com.example.demo.entity.form.*;
import com.example.demo.enums.ApplyTypeEnum;
import com.example.demo.enums.DeviceTypeEnum;
import com.example.demo.enums.FormTypeEnum;
import com.example.demo.service.Validatable;
import com.example.demo.service.utils.UtilServiceImpl;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class ApplyInfo  implements Serializable,Validatable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String codeId;
    private long deviceId=0;
    private long[] deviceList;
    @Column(nullable = false)
    private ApplyTypeEnum applyType;
    private long acceptorAgencyId;
    private String acceptorAgencyName;
    private String useComName;
    private String deviceCategory;
    private String deviceClass;
    private String deviceKind;
    private String deviceCode;
    @Column(nullable = false)
    private DeviceTypeEnum deviceType=DeviceTypeEnum.NULL;
    private String eqCode;
    private String eqUseAddr;
    private long ownerId;
    private String ownerName;
    private String registKind;
    private String safeAdministrator;
    private String registCode;
    private String comCode;
    private boolean processing=false;
    private String comTablePerson;
    private boolean hasFile=true;
    private long createTime;
    @ElementCollection(fetch = FetchType.EAGER)
    private Map<FormTypeEnum,Long> forms=new HashMap<>();
    @ElementCollection(fetch = FetchType.EAGER)
    private Map<String,Long> files=new HashMap<>();
    @OneToOne(cascade = CascadeType.ALL)
    private ApplyStatus status;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "ApplyFormList",joinColumns = {@JoinColumn(name = "applyId")},inverseJoinColumns = {@JoinColumn(name ="formId")})
    private List<Form> formList;
    public ApplyInfo(){
        createTime= UtilServiceImpl.getLongCurrTime();
        status=new ApplyStatus();
    }

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
    @Override
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

    public ApplyTypeEnum getApplyType() {
        return applyType;
    }

    public void setApplyType(ApplyTypeEnum applyType) {
        this.applyType = applyType;
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


    public ApplyStatus getStatus() {
        return status;
    }

    public void setStatus(ApplyStatus status) {
        this.status = status;
    }

    public String getDeviceCategory() {
        return deviceCategory;
    }

    public void setDeviceCategory(String deviceCategory) {
        this.deviceCategory = deviceCategory;
    }

    public String getDeviceClass() {
        return deviceClass;
    }

    public void setDeviceClass(String deviceClass) {
        this.deviceClass = deviceClass;
    }

    public String getDeviceKind() {
        return deviceKind;
    }

    public void setDeviceKind(String deviceKind) {
        this.deviceKind = deviceKind;
    }

    public DeviceTypeEnum getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceTypeEnum deviceType) {
        this.deviceType = deviceType;
    }

    public Map<String, Long> getObjForms() {
        Map<String,Long> stringform=new HashMap<>();
        for(Map.Entry<FormTypeEnum,Long> entry:forms.entrySet()){
            stringform.put(entry.getKey().toString(),entry.getValue());
        }
        return stringform;
    }

    public Map<FormTypeEnum,Long>getForms(){
        return forms;
    }

    public void setForms(Map<FormTypeEnum, Long> forms) {
        this.forms = forms;
    }


    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }



    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getRegistCode() {
        return registCode;
    }

    public void setRegistCode(String registCode) {
        this.registCode = registCode;
    }

    public String getEqCode() {
        return eqCode;
    }

    public void setEqCode(String eqCode) {
        this.eqCode = eqCode;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getComTablePerson() {
        return comTablePerson;
    }

    public void setComTablePerson(String comTablePerson) {
        this.comTablePerson = comTablePerson;
    }

    public String getSafeAdministrator() {
        return safeAdministrator;
    }

    public void setSafeAdministrator(String safeAdministrator) {
        this.safeAdministrator = safeAdministrator;
    }



    public List<Form> getFormList() {
        return formList;
    }

    public boolean setFormList(List<Form> formList) {
        if(formList.isEmpty()||formList==null)
        {return false;}
        Form form=formList.get(0);
        this.acceptorAgencyId=form.getAcceptorAgencyId();
        this.acceptorAgencyName=form.getAcceptorAgencyName();
        this.deviceCode=form.getDeviceClassCode();
        this.comCode=form.getEqComCode();
        if(form.getEqUseAddr()!=null){
        this.eqUseAddr=form.getEqUseAddr();}
        else{
            this.eqUseAddr=form.getUseComAddr();
        }
        this.useComName=form.getUseComName();
        this.registKind=form.getRegistKind();
        this.comTablePerson=form.getComTablePerson();
        this.deviceCode=form.getDeviceClassCode();
        if(form.getEqCode()!=null){
            this.eqCode=form.getEqCode();
        }
        if(form.getDeviceCategory()!=null){
            this.deviceCategory=form.getDeviceCategory();
        }
        if(form.getDeviceClass()!=null){
            this.deviceClass=form.getDeviceClass();
        }
        if(form.getDeviceKind()!=null){
            this.deviceKind=form.getDeviceKind();
        }
        if(form.getEqComCode()!=null){
            this.comCode=form.getEqComCode();
        }
        this.formList = formList;
        return true;
    }

    public String getRegistKind() {
        return registKind;
    }

    public void setRegistKind(String registKind) {
        this.registKind = registKind;
    }

    public Map<String, Long> getFiles() {
        return files;
    }

    public void setFiles(Map<String, Long> files) {
        this.files = files;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getUseComName() {
        return useComName;
    }

    public void setUseComName(String useComName) {
        this.useComName = useComName;
    }

    @Override
    public long getAcceptorAgencyId() {
        return acceptorAgencyId;
    }

    public void setAcceptorAgencyId(long acceptorAgencyId) {
        this.acceptorAgencyId = acceptorAgencyId;
    }

    public long[] getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(long[] deviceList) {
        deviceId=deviceList[0];
        this.deviceList = deviceList;
    }

    public String getEqUseAddr() {
        return eqUseAddr;
    }

    public void setEqUseAddr(String eqUseAddr) {
        this.eqUseAddr = eqUseAddr;
    }

    public boolean isProcessing() {
        return processing;
    }

    public void setProcessing(boolean processing) {
        this.processing = processing;
    }
}
