package com.leslie.springcloud_demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/consul")
    public String paymentConsul(){
        return "SpringCloud with consul port:"+port;
    }
}
