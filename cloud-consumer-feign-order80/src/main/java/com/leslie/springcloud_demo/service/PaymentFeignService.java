package com.leslie.springcloud_demo.service;

import com.leslie.springcloud_demo.entities.CommonResult;
import com.leslie.springcloud_demo.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    //远程调用，根据ID查找Payment
    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id);
}
