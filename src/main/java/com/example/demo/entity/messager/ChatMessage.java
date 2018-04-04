package com.example.demo.entity.messager;

/**
 * @author yang
 * @create_at 17-11-20
 **/
public class ChatMessage extends BaseMessager {
    private String receiver;

    public ChatMessage(String sender, String sendTime, String content, String receiver) {
        super(sender, content, sendTime);
        this.receiver = receiver;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
