package com.leslie.springcloud_demo.service.impl;

import com.leslie.springcloud_demo.entities.Payment;
import com.leslie.springcloud_demo.mapper.PaymentMapper;
import com.leslie.springcloud_demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public Payment getById(Long id) {
        return paymentMapper.getById(id);
    }

    @Override
    public Integer add(Payment payment) {
        return paymentMapper.add(payment);
    }
}
