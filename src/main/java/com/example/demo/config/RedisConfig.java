package com.example.demo.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig extends CachingConfigurerSupport {


    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory connectionFactory= new JedisConnectionFactory();
        connectionFactory.setHostName("10.210.59.79");
        connectionFactory.setPort(6379);
        return connectionFactory;
    }
    //如果在applicationContext中配置redisConnectionFactory那么加@autowired 和传入redisConnectionFactory类型参数如果如上直接配置就不用了。
    @Bean
    public RedisTemplate<String, Object> redisTemplate()
    {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
       // template.setValueSerializer(new JdkSerializationRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        //template.setHashValueSerializer(new JdkSerializationRedisSerializer());

        return template;
    }
    @Bean
    public CacheManager  cacheManager(RedisTemplate redisTemplate) {
        SpringRedisCacheManager cacheManager = new SpringRedisCacheManager(redisTemplate);
        // Number of seconds before expiration. Defaults to unlimited (0)
        cacheManager.setDefaultExpiration(20L);// Sets the default expire time (in seconds)
        return cacheManager;
    }
    /**
     * @description 自定义的缓存key的生成策略</br>
     *              若想使用这个key</br>
     *              只需要讲注解上keyGenerator的值设置为customKeyGenerator即可</br>
     * @return 自定义策略生成的key
     */
    @Bean
    public KeyGenerator customKeyGenerator() {
        return (o, method, objects) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(o.getClass().getName());
            sb.append(method.getName());
            for (Object obj : objects) {
                sb.append(obj.toString());
            }
            return sb.toString();
        };
    }


    @Override
    public KeyGenerator keyGenerator() {
        return customKeyGenerator();
    }
}