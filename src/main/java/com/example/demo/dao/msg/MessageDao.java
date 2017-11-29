package com.example.demo.dao.msg;

import com.example.demo.entity.data.Message;
import com.example.demo.enums.MsgType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author yang
 * @create_at 17-11-21
 **/
public interface MessageDao extends JpaRepository<Message,Integer> {
    List<Message> findAllByMsgType(MsgType msgType);
    List<Message> findAllByMsgTypeAndOwnerIdAndHasRead(MsgType msgType,long ownerId,boolean read);
    Message findById(long id);
}
