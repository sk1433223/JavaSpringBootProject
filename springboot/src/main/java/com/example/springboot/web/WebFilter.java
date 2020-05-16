package com.example.springboot.web;

import com.example.springboot.model.UserEntity;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName: WebFilter
 * @Description:
 * @Author: 阿康
 * @DateTime: 2020/5/1610:27
 */
@Component
public class WebFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        System.out.println("indexDoFilter");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession();

        UserEntity userEntity = (UserEntity) session.getAttribute("userEntity");
        if (userEntity!=null){
            chain.doFilter(request,response);
        }else {
            System.out.println("sorry this userEntity is null");
        }
    }

}
