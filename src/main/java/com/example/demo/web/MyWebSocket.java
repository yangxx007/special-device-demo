package com.example.demo.web;

import com.example.demo.config.GetHttpSessionConfigurator;
import com.example.demo.entity.user.UserInfo;
import com.example.demo.service.UserService;
import com.example.demo.service.UserStatusService;
import org.apache.shiro.SecurityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author yang
 * @create_at 17-11-16
 **/
@Controller
@ServerEndpoint(value = "/chatApp",configurator = GetHttpSessionConfigurator.class)
@Component
public class MyWebSocket {
    private static int onlineCount = 0;

    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();
    private static Map<String,Session> webSockets=new HashMap<>();
    private Session session;

    /**
     * ???????????*/
    @OnOpen
    public void onOpen(Session session) {
        System.out.print("session:");
        System.out.println(session.getId());
        this.session = session;
        webSockets.put(session.getUserPrincipal().getName(),session);
        webSocketSet.add(this);     //??set?
        addOnlineCount();           //????1
        System.out.println("online person number" + getOnlineCount());
        try {
            sendMessage("welcome");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    /**
     * ?????????
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //?set???
        webSockets.remove(session);
        subOnlineCount();           //????1
        System.out.println("online person number" + getOnlineCount());
    }

    /**
     * ?????????????
     *
     * @param message ??????????*/
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println(String.valueOf(session.getId())+":" + message);

        //????
        for (MyWebSocket item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


     @OnError
     public void onError(Session session, Throwable error) {
     System.out.println("error happened");
     error.printStackTrace();
     }


     public void sendMessage(String message) throws IOException {
     this.session.getBasicRemote().sendText(message);
     //this.session.getAsyncRemote().sendText(message);
     }




    public static void sendInfo(String message) throws IOException {
        for (MyWebSocket item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                continue;
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        MyWebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        MyWebSocket.onlineCount--;
    }
}
