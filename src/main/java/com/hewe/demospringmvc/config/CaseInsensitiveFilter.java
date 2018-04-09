package com.hewe.demospringmvc.config;


import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class CaseInsensitiveFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(servletRequest);

        filterChain.doFilter(new CaseInsensitiveRequest((HttpServletRequest) servletRequest),servletResponse);

    }

    @Override
    public void destroy() {
        System.out.println("filter destroy");
    }
}
