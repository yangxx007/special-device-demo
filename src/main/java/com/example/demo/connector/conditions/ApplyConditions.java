package com.example.demo.connector.conditions;

import com.example.demo.enums.RoleTypeEnum;
import org.springframework.data.domain.Sort;

/**
 * @author yang
 * @create_at 17-10-24
 **/
public class ApplyConditions extends SearchConditions {

    private RoleTypeEnum role=RoleTypeEnum.普通用户;
    private Sort sort;
    private int applyTypeId;
    private String eqCode;
    private boolean sendRegist=false;
    public Sort getSort() {
        return sort;
    }



    @Override
    public void setOrderBy(int orderBy) {
        super.setOrderBy(orderBy);
        switch (orderBy){
            case 1:
                sort = new Sort(Sort.Direction.ASC, "id");
                break;
            case 2:
                sort=new Sort(Sort.Direction.ASC, "createAt");
                break;
            case 3:
                sort=new Sort(Sort.Direction.ASC, "updateAt");
                break;
            default:
                sort=null;
        }
    }

    @Override
    public int getApplyTypeId() {
        return applyTypeId;
    }

    @Override
    public void setApplyTypeId(int applyTypeId) {
        this.applyTypeId = applyTypeId;
    }


    public String getEqCode() {
        return eqCode;
    }

    public void setEqCode(String eqCode) {
        this.eqCode = eqCode;
    }

    public RoleTypeEnum getRole() {
        return role;
    }

    public void setRole(RoleTypeEnum role) {
        this.role = role;
    }

    public boolean isSendRegist() {
        return sendRegist;
    }

    public void setSendRegist(boolean sendRegist) {
        this.sendRegist = sendRegist;
    }

}
