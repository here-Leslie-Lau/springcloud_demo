package com.leslie.springcloud_demo.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixService implements PaymentService{
    @Override
    public String paymentInfo_Ok(Integer id) {
        return "系统繁忙，请稍后再试 ------PaymentHystrixService:paymentInfo_Ok";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "系统繁忙，请稍后再试 ------PaymentHystrixService:paymentInfo_Timeout";
    }
}
