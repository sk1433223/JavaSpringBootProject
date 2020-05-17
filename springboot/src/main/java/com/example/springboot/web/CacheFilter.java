package com.example.springboot.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filter禁用浏览器缓存
 */
@Component
@Slf4j
public class CacheFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //  (Filter禁用浏览器缓存)
        //  在response的头部设置Cache-Control、Pragma 和 Expires 即可取消缓存
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Pragma","no-cache");
        response.setHeader("Expires","-1");
        log.info("info:"+this.getClass().getName());
        chain.doFilter(request,response);
    }
}
