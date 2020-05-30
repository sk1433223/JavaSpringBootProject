package com.example.springboot.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName: LoginFilter
 * @description:
 * @author 阿康
 * @DateTime: 2020/5/1517:06
 */
@Slf4j
@Component
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("login,login.html拦截");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession();
        // http://localhost/login
        StringBuffer url = request.getRequestURL();

        /* 放行 chain.doFilter(request,response) */
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {
        log.info("destroy");
    }
}
