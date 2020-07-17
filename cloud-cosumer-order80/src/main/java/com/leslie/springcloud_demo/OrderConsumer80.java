package com.leslie.springcloud_demo;

import com.leslie.ribbonRule.SelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = SelfRule.class)
public class OrderConsumer80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsumer80.class,args);
    }
}
