package com.example.demo.entity.messager;

import com.example.demo.service.utils.UtilServiceImpl;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yang
 * @create_at 17-11-20
 **/
public class BaseMessager implements Serializable{
    private String sender;
    private String sendTime;
    private String content;

    public BaseMessager(String sender,String content,String sendTime) {
        this.sender = sender;
        this.sendTime = sendTime;
        this.content = content;
    }

    public BaseMessager() {
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(Object sendTime) {
        try{
                this.sendTime=UtilServiceImpl.date2String((Date)sendTime,"yyyy年MM月dd日");
    }catch (Exception e){
                this.sendTime = (String) sendTime;
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
