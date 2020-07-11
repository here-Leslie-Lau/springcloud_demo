package springcloud_demo.service.impl;

import com.leslie.springcloud_demo.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springcloud_demo.mapper.PaymentMapper;
import springcloud_demo.service.PaymentService;

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
