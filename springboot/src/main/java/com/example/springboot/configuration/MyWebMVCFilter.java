package com.example.springboot.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * @ClassName: WebMVCFilterConfig
 * @Description:
 * @Author: 阿康
 * @DateTime: 2020/5/1815:33
 */
//@Configuration
public class MyWebMVCFilter implements WebMvcConfigurer {

    public InterceptorRegistry addFilter(InterceptorRegistry registry) {
        registry.addInterceptor(new LocaleChangeInterceptor())
                .addPathPatterns("/*")
                .excludePathPatterns("/", "/login", "login.html");
        return registry;
    }
}
