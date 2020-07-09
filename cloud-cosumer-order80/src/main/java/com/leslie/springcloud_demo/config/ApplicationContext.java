package com.leslie.springcloud_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContext {

    //将RestTemplate添加至容器中
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
