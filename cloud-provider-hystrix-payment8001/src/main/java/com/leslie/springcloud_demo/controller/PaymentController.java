package com.leslie.springcloud_demo.controller;

import com.leslie.springcloud_demo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Integer id) {

        String paymentInfo_ok = paymentService.paymentInfo_Ok(id);

        log.info("********"+paymentInfo_ok);

        return paymentInfo_ok;
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {

        String paymentInfo_Timeout = paymentService.paymentInfo_Timeout(id);

        log.info("********"+paymentInfo_Timeout);

        return paymentInfo_Timeout;
    }
}
