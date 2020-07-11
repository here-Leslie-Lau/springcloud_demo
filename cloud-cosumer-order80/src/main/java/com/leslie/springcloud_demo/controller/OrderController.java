package com.leslie.springcloud_demo.controller;



import com.leslie.springcloud_demo.entities.CommonResult;
import com.leslie.springcloud_demo.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    public static final String payment_url = "http://localhost:8001";

    @PostMapping("/consumer/payment")
    public CommonResult addPayment(Payment payment){

        log.info(payment+"------");
        CommonResult commonResult = restTemplate.postForObject(payment_url + "/payment", payment, CommonResult.class);

        return commonResult;
    }

    @GetMapping("/consumer/payment/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){
        CommonResult forObject = restTemplate.getForObject(payment_url + "/payment/" + id, CommonResult.class);

        log.info("查询结果:"+forObject);
        return forObject;
    }

}
