package springcloud_demo.mapper;

import com.leslie.springcloud_demo.entities.Payment;

public interface PaymentMapper {

    //根据id读取
    public Payment getById(Long id);

    //写
    public Integer add(Payment payment);
}
