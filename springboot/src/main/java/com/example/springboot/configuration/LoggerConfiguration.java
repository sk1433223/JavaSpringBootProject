package com.example.springboot.configuration;

import com.example.springboot.model.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 阿康
 * @date 2020/5/30 10:00
 * @ClassName: LoggerConfiguration
 * @description:
 */
@Configuration
public class LoggerConfiguration {

    private static final Logger log = LoggerFactory.getLogger(LoggerConfiguration.class);

    /**
     * 注入Bean同时打印 log.info("hello log.info!");
     */
    @Bean
    public UserEntity logMethod() {
        log.info("hello log.info!");
        return new UserEntity();
    }


}
