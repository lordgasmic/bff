package com.lordgasmic.bff;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BffApplication {
    private static final Logger logger = LoggerFactory.getLogger(BffApplication.class);
    
    public static void main(final String[] args) {
        SpringApplication.run(BffApplication.class, args);
    }
}
