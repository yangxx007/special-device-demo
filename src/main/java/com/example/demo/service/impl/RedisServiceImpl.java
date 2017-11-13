package com.example.demo.service.impl;

import com.example.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService{
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
}
