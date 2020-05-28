package com.example.springboot.configuration;

import com.example.springboot.web.CacheFilter;
import com.example.springboot.web.IsLoginFilter;
import com.example.springboot.web.LoginFilter;
import com.example.springboot.web.WebFilters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: FilterConfiguration
 * @Description: 自定义拦截
 * @Author: 阿康
 * @DateTime: 2020/5/169:28
 */
@Configuration
public class FilterLoginConfiguration {

    private final LoginFilter loginFilter;

    private final IsLoginFilter isLoginFilter;

    private final WebFilters webFilter;

    private final CacheFilter cacheFilter;

    public FilterLoginConfiguration(LoginFilter loginFilter, IsLoginFilter isLoginFilter, WebFilters webFilter, CacheFilter cacheFilter) {
        this.loginFilter = loginFilter;
        this.isLoginFilter = isLoginFilter;
        this.webFilter = webFilter;
        this.cacheFilter = cacheFilter;
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
        registration.setOrder(3); // 值越小，Filter越靠前。
        return registration;
    }

    @Bean
    public FilterRegistrationBean FilterisLoginConfiguration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(isLoginFilter);

        registration.setName("isLoginFilter");
        registration.setOrder(5); // 值越小，Filter越靠前。
        return registration;
    }

    @Bean
    public FilterRegistrationBean FilterWebConfiguration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(webFilter);

        registration.addUrlPatterns("/index");

        registration.setName("webFilter");
        registration.setOrder(10); // 值越小，Filter越靠前。
        return registration;
    }

    /**
     * 使用拦截器实现禁用浏览器缓存功能
     */
    @Bean
    public FilterRegistrationBean FilterCacheConfiguration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(cacheFilter);

        /*
         * 在访问login,login.html页面取消浏览器缓存功能
         * 也可以用/* 通配符
         */
        registration.addUrlPatterns("/login");

        registration.setName("cacheFilter");
        registration.setOrder(15); // 值越小，Filter越靠前。
        return registration;
    }
}
