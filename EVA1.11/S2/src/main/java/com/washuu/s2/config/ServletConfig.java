package com.washuu.s2.config;


import com.sun.net.httpserver.Filter;
import com.washuu.s2.filter.Filter1;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ServletConfig {


//    @Bean
//    public FilterRegistrationBean filterRegistrationBean2() {
//        FilterRegistrationBean reg = new FilterRegistrationBean();
//        reg.setFilter(new Filter1());
//        reg.addUrlPatterns("/*");
//        return reg;
//    }

//    @Bean
//    public FilterRegistrationBean filterRegistrationBean2() {  这个不需要，因为springboot自带有字符过滤器
//        FilterRegistrationBean reg = new FilterRegistrationBean();
//        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//        characterEncodingFilter.setEncoding("UTF-8");
//        characterEncodingFilter.setForceEncoding(true);
//        reg.setFilter(characterEncodingFilter);
//        reg.addUrlPatterns("/*");
//        return reg;
//    }


}
