package com.lordgasmic.bff.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.data.redis.RedisIndexedSessionRepository;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.data.redis.config.annotation.web.server.EnableRedisWebSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

@Configuration
@EnableRedisHttpSession
public class RedisHttpSessionConfiguration {

    private final RedisTemplate redisTemplate;

    public RedisHttpSessionConfiguration(final RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Bean
    @Primary
    public RedisIndexedSessionRepository sessionRepository() {
        final RedisIndexedSessionRepository sessionRepository = new RedisIndexedSessionRepository(redisTemplate);
        sessionRepository.setDefaultMaxInactiveInterval(5400);
        sessionRepository.setRedisKeyNamespace("webbff");
        return sessionRepository;
    }

    @Bean
    public CookieSerializer cookieSerializer() {
        final DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName("LORDGAMICEWEB");
        serializer.setDomainName("lordgasmic.com");
        return serializer;
    }
}
