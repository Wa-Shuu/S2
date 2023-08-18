package com.washuu.s2.config;

import com.washuu.s2.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String path [] = {"/*"};
        String excludePath [] = {"/s2"};
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns(path).excludePathPatterns(excludePath);
    }
}

