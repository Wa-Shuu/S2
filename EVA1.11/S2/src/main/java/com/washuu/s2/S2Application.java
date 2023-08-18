package com.washuu.s2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.washuu.s2.mapper")
public class S2Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(S2Application.class, args);
    }

}
