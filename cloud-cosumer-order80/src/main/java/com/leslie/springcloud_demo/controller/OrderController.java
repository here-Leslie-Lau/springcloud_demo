package com.leslie.springcloud_demo.controller;



import com.leslie.springcloud_demo.entities.CommonResult;
import com.leslie.springcloud_demo.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    public static final String payment_url = "http://CLOUD-PAYMENT-SERVICE";

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

    //测试getForEntity
    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult getPaymentById2(@PathVariable Long id){
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(payment_url + "/payment/" + id, CommonResult.class);

        log.info(responseEntity.getHeaders()+responseEntity.getStatusCode().toString());

        if (responseEntity.getStatusCode().is2xxSuccessful())
            return responseEntity.getBody();

        else
            return new CommonResult(404,"查询失败");
    }
}
