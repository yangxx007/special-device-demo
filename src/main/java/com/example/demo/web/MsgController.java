package com.example.demo.web;

import com.example.demo.dao.msg.MessageDao;
import com.example.demo.entity.data.Message;
import com.example.demo.enums.JsonResponse;
import com.example.demo.enums.MsgType;
import com.example.demo.service.UserStatusService;
import com.example.demo.service.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author yang
 * @create_at 17-11-22
 **/
@Controller
@RequestMapping("/notice")
public class MsgController extends BaseController{
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private UserStatusService statusService;
    @RequestMapping("/getSystemMsg")
    @ResponseBody
    public List<Message> getSystemMsg(){
        return messageDao.findAllByMsgType(MsgType.announce);

    }
    @RequestMapping("/getReminder")
    @ResponseBody
    public List<Message> getRemind(){
        return messageDao.findAllByMsgTypeAndOwnerIdAndHasRead(MsgType.reminder,
                statusService.getCurrUserId(getSession()),false);
    }
    @RequestMapping("/getReadReminder")
    @ResponseBody
    public List<Message> getReadRemind(){
        return messageDao.findAllByMsgTypeAndOwnerIdAndHasRead(MsgType.reminder,
                statusService.getCurrUserId(getSession()),true);
    }
    @RequestMapping("/getMessage")
    @ResponseBody
    public List<Message> getMessage(){
        return null;
    }
    @RequestMapping("/getReadMessage")
    @ResponseBody
    public List<Message> getReadMsg(){
        return null;
    }
    @RequestMapping("/read")
    @ResponseBody
    public JsonResponse readMsg(@RequestBody long[] readmsgIds){
        long ownerId= statusService.getCurrUserId(getSession());
        for(long id:readmsgIds){
            Message message=messageDao.findById(id);
            if(message.getOwnerId()==ownerId){
                message.setHasRead(true);
                messageDao.save(message);
            }else{
                throw new CustomException("Illegal operation");
            }
        }
        return new JsonResponse();
    }
}
