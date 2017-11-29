package com.example.demo.service.impl;

import com.example.demo.enums.Constants;
import com.example.demo.service.RedisService;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService,SessionDAO{
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Override
    public void save(String key,String type,Object object) {
       try {
           redisTemplate.opsForHash().put(key,type, object);
       }catch (Exception e){
           e.printStackTrace();
           System.out.println("redis failure");
       }
    }
    @Override
    public void save(String key,String type,Object object,long time) {
        save(key,type,object);
        System.out.println(redisTemplate.expire(key,time,TimeUnit.SECONDS));
        System.out.println(redisTemplate.getExpire(key));
    }

    @Override
    public Object find(String key, String type) {
        try{return redisTemplate.opsForHash().get(key,type);}
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("redis failure");
        }
        return null;
    }


    @Override
    public void delete(String key, String field) {

    }

    @Override
    public void deleteByKey(String key) {

    }

    @Override
    public void incr(String key) {
    }

    @Override
    public Serializable create(Session session) {
        save(Constants.HTTP_SESSION,session.getId().toString(),session,72000);
        return session.getId();
    }

    @Override
    public Session readSession(Serializable serializable) throws UnknownSessionException {
        return (Session) find(Constants.HTTP_SESSION,serializable.toString());
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        save(Constants.HTTP_SESSION,session.getId().toString(),session);
    }

    @Override
    public void delete(Session session) {
        delete(Constants.HTTP_SESSION,session.getId().toString());
    }

    @Override
    public Collection<Session> getActiveSessions() {
        List<Session> sessions=new ArrayList<>();
        for(Object object:redisTemplate.opsForHash().values(Constants.HTTP_SESSION))
        {
            sessions.add((Session)object);
        }
        return  sessions;
         //return (List<Session>) redisTemplate.opsForHash().values(Constants.HTTP_SESSION);
    }
}
