package com.firstHelp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class FirstHelpApplication {
    public static void main(String[] args) {
        SpringApplication.run(FirstHelpApplication.class, args);
    }
}
