package com.leslie.springcloud_demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

    @Value("${config.info}")
    private String info;

    @GetMapping("/configInfo")
    public String getInfo() {
        return info;
    }
}
