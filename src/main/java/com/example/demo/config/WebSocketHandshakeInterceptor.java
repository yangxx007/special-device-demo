package com.example.demo.config;

import com.example.demo.enums.Constants;
import org.apache.bcel.classfile.Constant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author yang
 * @create_at 17-11-24
 **/
public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {

    private static Log logger = LogFactory.getLog(HandshakeInterceptor.class);
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object
                > attributes) throws Exception {
        logger.debug("beforeHandshake start.....");
        logger.debug(request.getClass().getName());
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession(false);
            if (session != null) {
                Enumeration<String> attributeNames=session.getAttributeNames();
                while (attributeNames.hasMoreElements()){
                    String attributeName=attributeNames.nextElement();
                    attributes.put(attributeName,session.getAttribute(attributeName));
                }
//                    attributes.put(Constants.PROCESSING_APPLY_ID,session.getAttribute(Constants.PROCESSING_APPLY_ID));
            }else{
                logger.debug("httpsession is null");
            }
        }
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
    }
}