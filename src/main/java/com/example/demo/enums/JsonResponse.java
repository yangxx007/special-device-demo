package com.example.demo.enums;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonResponse {
    private int status=200;
    private String msg;
    private Object data;
    public  JsonResponse(int status,String msg,Object data){
        this.status=status;
        this.msg=msg;
        this.data=data;
    }
    public  JsonResponse(){
    }
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
