package com.leslie.springcloud_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerZkOrder80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerZkOrder80.class,args);
    }
}
