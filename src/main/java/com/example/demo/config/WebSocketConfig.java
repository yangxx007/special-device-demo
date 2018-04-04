package com.example.demo.config;

import com.example.demo.dao.apply.ApplyInfoDao;
import com.example.demo.entity.data.ApplyInfo;
import com.example.demo.enums.Constants;

import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;

import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.handler.WebSocketHandlerDecorator;
import org.springframework.web.socket.handler.WebSocketHandlerDecoratorFactory;


/**
 * @author yang
 * @create_at 17-11-16
 **/
@Slf4j
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Autowired
    private ApplyInfoDao applyInfoDao;
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        // 添加服务端点，可以理解为某一服务的唯一key值

        stompEndpointRegistry.addEndpoint("/processing").addInterceptors(new WebSocketHandshakeInterceptor());
        stompEndpointRegistry.addEndpoint("/processing").setAllowedOrigins("*").withSockJS().setInterceptors(new WebSocketHandshakeInterceptor());
        //当浏览器支持sockjs时执行该配置
       // stompEndpointRegistry.addEndpoint("/processing").addInterceptors(new WebSocketHandshakeInterceptor()).setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // 配置接受订阅消息地址前缀为topic的消息
        config.enableSimpleBroker("/topic");
        // Broker接收消息地址前缀
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void configureWebSocketTransport(final WebSocketTransportRegistration registration) {
        registration.addDecoratorFactory(new WebSocketHandlerDecoratorFactory() {
            @Override
            public WebSocketHandler decorate(final WebSocketHandler handler) {
                return new WebSocketHandlerDecorator(handler) {
                    @Override
                    public void afterConnectionEstablished(final WebSocketSession session) throws Exception {
                        // 客户端与服务器端建立连接后，此处记录谁上线了
                        //String username = session.getPrincipal().getName();
                        // System.out.println("online: " + username);

                        //HttpSession httpSession = (HttpSession) session.getAttributes().get(Constants.HTTP_SESSION);
                        if (session.getAttributes().get(Constants.PROCESSING_APPLY_ID) != null) {
                            ApplyInfo applyInfo = applyInfoDao.findApplyInfoById((long) session.getAttributes().get(Constants.PROCESSING_APPLY_ID));
                            log.info(session.getAttributes().get(Constants.PROCESSING_APPLY_ID)+" start processing");
                            applyInfo.setProcessing(true);
                            applyInfoDao.save(applyInfo);
                        }
                        super.afterConnectionEstablished(session);
                    }

                    @Override
                    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
                        // 客户端与服务器端断开连接后，此处记录谁下线了
                        // String username = session.getPrincipal().getName();
                        // System.out.println("offline: " + username);

                        if (session.getAttributes().get(Constants.PROCESSING_APPLY_ID) != null) {
                            ApplyInfo applyInfo = applyInfoDao.findApplyInfoById((long) session.getAttributes().get(Constants.PROCESSING_APPLY_ID));
                            log.info(session.getAttributes().get(Constants.PROCESSING_APPLY_ID)+" end processing");
                            applyInfo.setProcessing(false);
                            applyInfoDao.save(applyInfo);
                        }
                        super.afterConnectionClosed(session, closeStatus);
                    }
                };
            }
        });
        super.configureWebSocketTransport(registration);
    }


}
