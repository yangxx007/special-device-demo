package com.example.demo.config;

import com.example.demo.config.annotation.CacheDuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

import static com.google.common.collect.Sets.newHashSet;
import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;
import static org.springframework.util.StringUtils.isEmpty;

public class SpringRedisCacheManager extends RedisCacheManager implements ApplicationContextAware, InitializingBean {
    private ApplicationContext applicationContext;
    private long defaultExpireTime;
    private static Logger logger = LoggerFactory.getLogger(SpringRedisCacheManager.class);



    @Override
    public Cache getCache(String name) {
        return new RedisCacheWrapper(super.getCache(name));
    }


    protected static class RedisCacheWrapper implements Cache {

        private final Cache delegate;

        public RedisCacheWrapper(Cache redisCache) {
            Assert.notNull(redisCache, "delegate cache must not be null");
            this.delegate = redisCache;
        }

        @Override
        public String getName() {
            try {
                return delegate.getName();
            } catch (Exception e) {
                return handleException(e);
            }
        }

        @Override
        public Object getNativeCache() {
            try {
                return delegate.getNativeCache();
            } catch (Exception e) {
                return handleException(e);
            }
        }

        @Override
        public Cache.ValueWrapper get(Object key) {
            try {
                return delegate.get(key);
            } catch (Exception e) {
                return handleException(e);
            }
        }

        @Override
        public <T> T get(Object o, Class<T> aClass) {
            try {
                return delegate.get(o, aClass);
            } catch (Exception e) {
                return handleException(e);
            }
        }

        @Override
        public <T> T get(Object o, Callable<T> callable) {
            try {
                return delegate.get(o, callable);
            } catch (Exception e) {
                return handleException(e);
            }
        }

        @Override
        public void put(Object key, Object value) {
            try {
                delegate.put(key, value);
            } catch (Exception e) {
                handleException(e);
            }
        }

        @Override
        public ValueWrapper putIfAbsent(Object o, Object o1) {
            try {
                return delegate.putIfAbsent(o, o1);
            } catch (Exception e) {
                return handleException(e);
            }
        }

        @Override
        public void evict(Object o) {
            try {
                delegate.evict(o);
            } catch (Exception e) {
                handleException(e);
            }
        }

        @Override
        public void clear() {
            try {
                delegate.clear();
            } catch (Exception e) {
                handleException(e);
            }
        }

        private <T> T handleException(Exception e) {
            logger.error("handleException", e);
            return null;
        }
    }
    public SpringRedisCacheManager(RedisOperations redisOperations) {
        super(redisOperations);
    }

    @Override
    public void setDefaultExpiration(long defaultExpireTime) {
        this.defaultExpireTime=defaultExpireTime;
        //super.setDefaultExpiration(defaultExpireTime);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    @Override
    public void afterPropertiesSet() {
        parseCacheDuration(applicationContext);
    }
    private void parseCacheDuration(ApplicationContext applicationContext) {
        final Map<String, Long> cacheExpires = new HashMap<>();
        String[] beanNames = applicationContext.getBeanNamesForType(Object.class);
        for (String beanName : beanNames) {
            final Class clazz = applicationContext.getType(beanName);
            Service service = findAnnotation(clazz, Service.class);

            if (null == service) {
                continue;
            }
            addCacheExpires(clazz, cacheExpires);
        }
        //设置有效期
        super.setExpires(cacheExpires);
    }
    private void addCacheExpires(final Class clazz, final Map<String, Long> cacheExpires) {
        ReflectionUtils.doWithMethods(clazz, new ReflectionUtils.MethodCallback() {
            @Override
            public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
                ReflectionUtils.makeAccessible(method);
                long duration;
                try{
                CacheDuration cacheDuration = findCacheDuration(clazz, method);
                duration=cacheDuration.duration();
                }
                catch (Exception e){
                    duration=defaultExpireTime;
                    System.out.println("it doesn't matter without CacheDuration");
                }
                Cacheable cacheable = findAnnotation(method, Cacheable.class);
                CacheConfig cacheConfig = findAnnotation(clazz, CacheConfig.class);

                Set<String> cacheNames = findCacheNames(cacheConfig, cacheable);
                for (String cacheName : cacheNames) {
                    cacheExpires.put(cacheName, duration);
                }
            }
        }, new ReflectionUtils.MethodFilter() {
            @Override
            public boolean matches(Method method) {
                return null != findAnnotation(method, Cacheable.class);
            }
        });
    }
    /**
     * CacheDuration标注的有效期，优先使用方法上标注的有效期
     * @param clazz
     * @param method
     * @return
     */
    private CacheDuration findCacheDuration(Class clazz, Method method) {
        CacheDuration methodCacheDuration = findAnnotation(method, CacheDuration.class);
        if (null != methodCacheDuration) {
            return methodCacheDuration;
        }
        CacheDuration classCacheDuration = findAnnotation(clazz, CacheDuration.class);
        if (null != classCacheDuration) {
            return classCacheDuration;
        }

        throw new IllegalStateException("No CacheDuration config on Class " + clazz.getName() + " and method " +
                method.toString());
    }
    private Set<String> findCacheNames(CacheConfig cacheConfig, Cacheable cacheable) {
        return isEmpty(cacheable.value()) ?
                newHashSet(cacheConfig.cacheNames()) : newHashSet(cacheable.value());
    }
}
