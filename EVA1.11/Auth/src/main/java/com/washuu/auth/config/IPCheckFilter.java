package com.washuu.auth.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Component
public class IPCheckFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String ip = exchange.getRequest().getHeaders().getHost().getHostName();
            //这里写死了，只做演示
        if (!ip.equals("localhost")) {
            //说明是黑名单里面的 ip
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            Map<String, Object> map = new HashMap<>();
            map.put("code", HttpStatus.UNAUTHORIZED);
            map.put("msg", "非法访问");
            response.getHeaders().add("content-Type",
                    "application/json;charset=UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            byte[] bytes = new byte[0];
            try {
                bytes = objectMapper.writeValueAsBytes(map);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            DataBuffer buffer = response.bufferFactory().wrap(bytes);
            return response.writeWith(Mono.just(buffer));
        }
        return chain.filter(exchange);
    }
    /**
     * 设置此过滤器的执行顺序
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 1;
    }
}
