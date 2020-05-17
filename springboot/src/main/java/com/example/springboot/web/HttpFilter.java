package com.example.springboot.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpFilter implements Filter {

    private FilterConfig filterConfig;

    public FilterConfig getFilterConfig() {
        return this.filterConfig;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        init();
    }

    /**
     * 这个init方法,提供给子类覆盖的方法
     */
    protected void init() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        doFilter((HttpServletRequest)request,(HttpServletResponse)response,chain);
    }

    /**
     * 这个doFilter,是提供给子类覆盖的方法
     * @param request
     * @param response
     * @param chain
     */
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
