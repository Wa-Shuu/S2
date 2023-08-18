package com.washuu.s2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner1 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception{
        System.out.println("completely");
    }
}
