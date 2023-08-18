package com.washuu.s2.filter;


import com.washuu.s2.domain.User;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//
//@Component
public class Filter1 implements Filter {
    @Value("${mys2.login.url}")
    private String loginUrl="http://localhost:8080/s2/#/login";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//        HttpSession session = req.getSession(true);
//        String url = req.getRequestURI();
//        System.out.println(url);
////        if(url.equals(loginUrl) && session != null && ((User)session.getAttribute("user")).getState().equals("Logged_In")) {
//        if(url.equals(loginUrl) ) {
//            filterChain.doFilter(servletRequest, servletResponse);
//        } else {
//            System.out.println("Filter1");
//            System.out.println(url);
//            System.out.println(loginUrl);
//            resp.sendRedirect("/s2/");
//        }
    }
}
