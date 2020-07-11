package springcloud_demo.service;

import com.leslie.springcloud_demo.entities.Payment;

public interface PaymentService {

    //根据id读取
    public Payment getById(Long id);

    //写
    public Integer add(Payment payment);
}
