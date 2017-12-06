package com.example.demo.connector.conditions;

import com.example.demo.service.utils.UtilServiceImpl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SearchConditions implements Serializable {
    private String[] time;
    private int page=0;
    private int size=3;
    private long userId;
    private int deviceTypeId;
    private int applyTypeId;
    private int[] states;
    private int OrderBy;
    private boolean viewAll=true;




    public long getAgencyId() {
        return AgencyId;
    }

    public void setAgencyId(long agencyId) {
        AgencyId = agencyId;
    }

    private long AgencyId;


    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    private int roleId;

    public String[] getTime() {
        return time;
    }

    public void setTime(String[] time) {
        this.time = time;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }



    public long[] parseTime(String format) throws Exception{
        long[] long_time=new long[2];
        if(time!=null){
            long_time[0]= UtilServiceImpl.string2Long(time[0],format);
            long_time[1]=UtilServiceImpl.string2Long(time[1],format)+ 86400000;
            return long_time;
        }
        long_time[0]=0;
        long_time[1]=UtilServiceImpl.date2Long(new Date());
        return long_time;
    }

    public int getOrderBy() {
        return OrderBy;
    }

    public void setOrderBy(int orderBy) {
        OrderBy = orderBy;
    }

    public int getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(int deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public int getApplyTypeId() {
        return applyTypeId;
    }

    public void setApplyTypeId(int applyTypeId) {
        this.applyTypeId = applyTypeId;
    }


    public int[] getStates() {
        return states;
    }

    public void setStates(int[] states) {
        this.states = states;
    }

    public boolean isViewAll() {
        return viewAll;
    }

    public void setViewAll(boolean viewAll) {
        this.viewAll = viewAll;
    }
}
