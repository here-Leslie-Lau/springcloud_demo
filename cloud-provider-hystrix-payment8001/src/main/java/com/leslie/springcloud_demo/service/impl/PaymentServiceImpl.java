package com.leslie.springcloud_demo.service.impl;

import cn.hutool.core.util.IdUtil;
import com.leslie.springcloud_demo.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfo_Ok(Integer id) {
        return "线程池:\t"+Thread.currentThread().getName()+"\tpaymentInfo_Ok,id:\t"+id;
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {

        //手动控制睡眠秒数，用来模拟复杂程序的情况
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //模拟运行时错误
//        int temp = 10 / 0;

        return "线程池:\t"+Thread.currentThread().getName()+"\tpaymentInfo_Timeout,id:\t"+id;
    }

    //服务熔断
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_Handler",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")//跳闸所需失败率
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0)
            throw new RuntimeException("*******id不能为负数");

        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t调用成功,流水号:"+serialNumber;
    }

    public String paymentCircuitBreaker_Handler(@PathVariable("id") Integer id){
        return "调用失败，id不能为负数，id："+id;
    }
}
