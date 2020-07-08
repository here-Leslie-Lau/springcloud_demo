package com.leslie.springcloud_demo.controller;

import com.leslie.springcloud_demo.entities.CommonResult;
import com.leslie.springcloud_demo.entities.Payment;
import com.leslie.springcloud_demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment")
    public CommonResult add(Payment payment){
        Integer result = paymentService.add(payment);

        if (result >= 1)
            return new CommonResult(200,"插入成功",result);
        else
            return new CommonResult(400,"插入失败");
    }

    @GetMapping("/payment/{id}")
    public CommonResult getById(@PathVariable Long id){
        Payment byId = paymentService.getById(id);

        if (byId != null)
            return new CommonResult(200,"查询成功",byId);

        else
            return new CommonResult(404,"查询失败,失败id:"+id);
    }
}