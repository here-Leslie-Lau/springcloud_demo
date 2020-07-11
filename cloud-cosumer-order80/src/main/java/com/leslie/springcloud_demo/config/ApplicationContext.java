package com.leslie.springcloud_demo.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContext {

    //将RestTemplate添加至容器中
    @Bean
    @LoadBalanced //对ResetTemplate添加负载均衡,默认采用轮转算法
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
