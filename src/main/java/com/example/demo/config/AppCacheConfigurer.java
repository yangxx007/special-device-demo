package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.RedisConnectionFailureException;
import redis.clients.jedis.exceptions.JedisConnectionException;
//
//@Configuration
//@EnableCaching
public class AppCacheConfigurer extends CachingConfigurerSupport {

    private Logger logger = LoggerFactory.getLogger(AppCacheConfigurer.class);

    public class AppCacheErrorHandler implements CacheErrorHandler {

        @Override
        public void handleCacheGetError(RuntimeException e, Cache cache, Object o) {

            if(e instanceof JedisConnectionException || e instanceof RedisConnectionFailureException){
                logger.warn("redis has lose connection:",e);
                return;
            }
            throw e;
        }

        @Override
        public void handleCachePutError(RuntimeException e, Cache cache, Object o, Object o1) {
            if(e instanceof JedisConnectionException || e instanceof RedisConnectionFailureException){
                logger.warn("redis has lose connection:",e);
                return;
            }
            throw e;
        }

        @Override
        public void handleCacheEvictError(RuntimeException e, Cache cache, Object o) {
            throw e;
        }

        @Override
        public void handleCacheClearError(RuntimeException e, Cache cache) {
            throw e;
        }
    }

    @Override
    public CacheErrorHandler errorHandler() {
        return new AppCacheErrorHandler();
    }

}