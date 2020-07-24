package com.leslie.springcloud_demo.service;

public interface PaymentService {

    //成功访问的接口
    public String paymentInfo_Ok(Integer id);

    //超时访问接口
    public String paymentInfo_Timeout(Integer id);

    public String paymentCircuitBreaker(Integer id);
}
