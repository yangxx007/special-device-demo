package com.example.demo.enums;

public class JsonResponse {




    private boolean status;
    private String msg;
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
