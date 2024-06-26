package com.lordgasmic.bff;

import com.lordgasmic.bff.configuration.LordgasmicRequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableFeignClients
@Slf4j
public class BffApplication {

    public static void main(final String[] args) {
        SpringApplication.run(BffApplication.class, args);
    }

    @Bean
    public LordgasmicRequestInterceptor bffRequestInterceptor() {
        return new LordgasmicRequestInterceptor();
    }

    @Bean
    public WebMvcConfigurer adapter() {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(final InterceptorRegistry registry) {
                registry.addInterceptor(bffRequestInterceptor());
            }
        };
    }
}
