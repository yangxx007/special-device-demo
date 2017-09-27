package com.example.demo.enums;

import com.example.demo.service.view.View;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonResponse {
    @JsonView(View.ApplyForView.class)
    private boolean status;
    @JsonView(View.ApplyForView.class)
    private String msg;
    @JsonView(View.ApplyForView.class)
    private Object data;
    public  JsonResponse(boolean status,String msg,Object data){
        this.status=status;
        this.msg=msg;
        this.data=data;
    }
    public  JsonResponse(){
    }
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
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
