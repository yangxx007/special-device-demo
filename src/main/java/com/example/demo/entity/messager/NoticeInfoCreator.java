package com.example.demo.entity.messager;

import com.example.demo.enums.NoticeTypeEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yang
 * @create_at 17-11-20
 **/
public class NoticeInfoCreator {
    public String createInfo(NoticeTypeEnum notice, String content){
        Map<String,String> message=new HashMap<>();
        switch (notice){
            case Info:
                message.put("Info",content);
                break;
            case Error:
                message.put("Error",content);
                break;
            case Message:
                message.put("Message",content);
                break;
        }
        return message.toString();
    }
}
