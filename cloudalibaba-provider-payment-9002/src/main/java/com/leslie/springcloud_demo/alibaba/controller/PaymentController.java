package com.leslie.springcloud_demo.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/nacos/payment/{id}")
    public String getPayment(@PathVariable Integer id){
        return "nacos register, port=" + port + "\t id:" + id;
    }
}
