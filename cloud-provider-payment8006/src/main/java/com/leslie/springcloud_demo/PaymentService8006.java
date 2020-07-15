package com.leslie.springcloud_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentService8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentService8006.class,args);
    }
}
