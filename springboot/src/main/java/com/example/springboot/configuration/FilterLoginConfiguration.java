package com.example.springboot.configuration;

import com.example.springboot.web.LoginFilter;
import com.example.springboot.web.WebFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: FilterConfiguration
 * @Description:
 * @Author: 阿康
 * @DateTime: 2020/5/169:28
 */
@Configuration
public class FilterLoginConfiguration {

    private final LoginFilter loginFilter;

    private final WebFilter webFilter;

    public FilterLoginConfiguration(LoginFilter loginFilter, WebFilter webFilter) {
        this.loginFilter = loginFilter;
        this.webFilter = webFilter;
    }



    /**
     * 拦截指定的页面路径,跳转指定的拦截类进行处理
     */
    @Bean
    public FilterRegistrationBean FilterLoginConfiguration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(loginFilter);

        registration.addUrlPatterns("/login.html");
        registration.addUrlPatterns("/login");

        registration.setName("loginFilter");
        registration.setOrder(1); // 值越小，Filter越靠前。
        return registration;
    }

    @Bean
    public FilterRegistrationBean FilterWebConfiguration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(webFilter);

        registration.addUrlPatterns("/index");
        registration.addUrlPatterns("/index.html");

        registration.setName("webFilter");
        registration.setOrder(5); // 值越小，Filter越靠前。
        return registration;
    }
}
