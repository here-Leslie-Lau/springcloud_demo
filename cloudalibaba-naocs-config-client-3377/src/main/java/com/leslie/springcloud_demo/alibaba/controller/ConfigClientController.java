package com.leslie.springcloud_demo.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RefreshScope //nacos支持动态刷新
public class ConfigClientController {

    @Value("${config.info}")
    private String info;

    @GetMapping("/config/info")
    public String getInfo() {
        return info;
    }
}
