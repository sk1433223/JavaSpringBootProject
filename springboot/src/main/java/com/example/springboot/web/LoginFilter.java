package com.example.springboot.web;

import com.example.springboot.model.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: LoginFilter
 * @Description:
 * @Author: 阿康
 * @DateTime: 2020/5/1517:06
 */
@Component
@Slf4j
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter");
        System.out.println("login,login.html拦截");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String path = request.getContextPath();
        Cookie[] cookies = request.getCookies();


        StringBuffer url = request.getRequestURL();

        System.out.println(url+"::"+path);

        if (url!=null){
            /**
             * 放行 chain.doFilter(request,response);
             */
            chain.doFilter(request,response);
        }else {
            System.out.println("ErrorChain!");
        }

    }

    @Override
    public void destroy() {
        log.info("destroy");
    }
}
