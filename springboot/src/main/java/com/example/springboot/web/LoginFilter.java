package com.example.springboot.web;

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
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter");
        System.out.println("login,login.html拦截");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //  (Filter禁用浏览器缓存)
        //  在response的头部设置Cache-Control、Pragma 和 Expires 即可取消缓存
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Pragma","no-cache");
        response.setHeader("Expires","-1");

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
        System.out.println("destroy");

    }
}
