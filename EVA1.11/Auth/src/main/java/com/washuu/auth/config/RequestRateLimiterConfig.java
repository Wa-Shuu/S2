package com.washuu.auth.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

@Configuration
public class RequestRateLimiterConfig {
    /**
     * IP 限流
     * 把用户的 IP 作为限流的 Key
     *
     * @return
     */
    @Bean
    @Primary
    public KeyResolver hostAddrKeyResolver() {
        return (exchange) -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }
    /**
     * 用户 id 限流
     * 把用户 ID 作为限流的 key
     *
     * @return
     */
    @Bean
    public KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
    }
    /**
     * 请求接口限流
     * 把请求的路径作为限流 key
     *
     * @return
     */
    @Bean
    public KeyResolver apiKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getPath().value());
    }
}

