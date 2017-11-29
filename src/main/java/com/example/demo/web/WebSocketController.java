package com.example.demo.web;

import com.example.demo.entity.data.ApplyInfo;
import com.example.demo.entity.messager.BaseMessager;
import com.example.demo.service.ApplyService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yang
 * @create_at 17-11-20
 **/
@Controller
public class WebSocketController extends BaseController{
    @Autowired
   private SimpMessagingTemplate template;
    @Autowired
    private ApplyService applyService;
//    @MessageMapping("/chat")
//    @SendTo("/topic/messages")
//    public BaseMessager receiveAndSend(@RequestBody BaseMessager inputMessage) throws Exception {
//        System.out.println("get message (" + inputMessage.getContent() + ") from client!");
//        System.out.println("send messages to all subscribers!");
//        String time = new SimpleDateFormat("HH:mm").format(new Date());
//        return new BaseMessager(inputMessage.getSender(), inputMessage.getContent(), time);
//    }
    @MessageMapping("/app/processingApply")
    public void processingApply(@RequestBody long applyId, HttpServletRequest request){
        ApplyInfo applyInfo=applyService.findByApplyID(applyId,getSession());
        applyInfo.setProcessing(true);
        applyService.saveApply(applyInfo,getSession());

        getSession().setAttribute("processingApplyId",applyId);
    }
    @MessageMapping("/app/endProcessingApply")
    public void endprocessingApply(@RequestBody long applyId){
        ApplyInfo applyInfo=applyService.findByApplyID(applyId,getSession());
        applyInfo.setProcessing(false);
        applyService.saveApply(applyInfo,getSession());
    }
    //或者直接从服务端发送消息给指定客户端
//    @MessageMapping("/chat_user")
//    public void sendToSpecifiedUser(@Payload BaseMessager inputMessage, SimpMessageHeaderAccessor headerAccessor) throws Exception {
//        System.out.println("get message from client (" + inputMessage.getSender() + ")");
//        System.out.println("send messages to the specified subscriber!");
//        String time = new SimpleDateFormat("HH:mm").format(new Date());
//        this.template.convertAndSend("/topic/" + inputMessage.getSender(), new BaseMessager(inputMessage.getSender(), inputMessage.getContent(), time));
//    }


}
