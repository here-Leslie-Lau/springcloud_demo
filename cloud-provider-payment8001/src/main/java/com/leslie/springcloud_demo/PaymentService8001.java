package com.leslie.springcloud_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.leslie.springcloud_demo.mapper")
public class PaymentService8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentService8001.class,args);
    }
}
