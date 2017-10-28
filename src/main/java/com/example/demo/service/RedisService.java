package com.example.demo.service;
/**
 * @author yang
 * @create_at 2017/10/17
 **/
public interface RedisService {
    public static final String USERSTATUS="userInfo";
    public static final String THUMBNAIL="thumbnail";
    void save(String key,String type,Object object);
    void save(String key,String type,Object object,long time);
    Object find(String key,String type);
    void delete(String key,String type);
    void deleteByKey(String key);

}
