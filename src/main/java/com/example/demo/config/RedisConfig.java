package com.example.demo.config;

import com.example.demo.entity.userModel.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {


    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory connectionFactory= new JedisConnectionFactory();
        connectionFactory.setPort(6379);
        return connectionFactory;
    }
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory)
    {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new Jackson2JsonRedisSerializer<UserInfo>(UserInfo.class));
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new Jackson2JsonRedisSerializer<UserInfo>(UserInfo.class));

        return template;
    }

}