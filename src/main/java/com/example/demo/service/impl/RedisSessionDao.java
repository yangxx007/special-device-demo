package com.example.demo.service.impl;

import com.example.demo.enums.Constants;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yang
 * @create_at 17-11-30
 **/
public class RedisSessionDao extends AbstractSessionDAO {

    // Session超时时间，单位为毫秒
    private long expireTime = 120000;

    @Autowired
    private RedisTemplate redisTemplate;// Redis操作类，对这个使用不熟悉的，可以参考前面的博客

    public RedisSessionDao() {
        super();
    }
    public RedisSessionDao(long expireTime, RedisTemplate redisTemplate) {
        super();
        this.expireTime = expireTime;
        this.redisTemplate = redisTemplate;
    }

    @Override // 更新session
    public void update(Session session) throws UnknownSessionException {
        System.out.println("===============update================");
        if (session == null || session.getId() == null) {
            return;
        }
        session.setTimeout(expireTime);
        redisTemplate.opsForValue().set(Constants.HTTP_SESSION+session.getId().toString(), session, expireTime,TimeUnit.SECONDS);
    }

    @Override // 删除session
    public void delete(Session session) {
        System.out.println("===============delete================");
        if (null == session) {
            return;
        }
        redisTemplate.delete(Constants.HTTP_SESSION+session.getId());
    }

    @Override// 获取活跃的session，可以用来统计在线人数，如果要实现这个功能，可以在将session加入redis时指定一个session前缀，统计的时候则使用keys("session-prefix*")的方式来模糊查找redis中所有的session集合
    public Collection<Session> getActiveSessions() {
        System.out.println("==============getActiveSessions=================");
        List<Session> sessions=new ArrayList<>();
        for(Object object:redisTemplate.keys(Constants.HTTP_SESSION+"*")){
            System.out.println(object);
            Session session=(Session) redisTemplate.opsForValue().get(object);
            sessions.add((Session) redisTemplate.opsForValue().get(object));
            System.out.println(new JSONObject(session));
        }
        return sessions;
        //return redisTemplate.keys(Constants.HTTP_SESSION+"*");
    }

    @Override// 加入session
    protected Serializable doCreate(Session session) {
        System.out.println("===============doCreate================");
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);

        redisTemplate.opsForValue().set(Constants.HTTP_SESSION+session.getId(), session, expireTime, TimeUnit.MILLISECONDS);
        return sessionId;
    }

    @Override// 读取session
    protected Session doReadSession(Serializable sessionId) {
        System.out.println("==============doReadSession=================");
        if (sessionId == null) {
            return null;
        }
        return (Session) redisTemplate.opsForValue().get(Constants.HTTP_SESSION+sessionId);
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}