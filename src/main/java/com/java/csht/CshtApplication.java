package com.java.csht;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:config.properties")
@MapperScan(basePackages = "com.java.csht.mapper")
public class CshtApplication {

    public static void main(String[] args) {
        SpringApplication.run(CshtApplication.class, args);
    }

}
