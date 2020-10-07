package com.lordgasmic.bff.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

@Configuration
public class RedisHttpSessionConfiguration {

    @Bean
    public CookieSerializer cookieSerializer() {
        final DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName("LORDGAMICEWEB");
        serializer.setDomainName("lordgasmic.com");
        return serializer;
    }
}
