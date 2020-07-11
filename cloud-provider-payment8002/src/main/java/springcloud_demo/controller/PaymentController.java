package springcloud_demo.controller;

import com.leslie.springcloud_demo.entities.CommonResult;
import com.leslie.springcloud_demo.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import springcloud_demo.service.PaymentService;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping("/payment")
    public CommonResult add(@RequestBody Payment payment){

        log.info(payment.toString());

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
            return new CommonResult(200,"查询成功,端口:"+port,byId);

        else
            return new CommonResult(404,"查询失败,失败id:"+id);
    }
}
