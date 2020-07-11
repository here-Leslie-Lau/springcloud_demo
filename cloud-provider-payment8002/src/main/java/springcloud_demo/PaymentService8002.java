package springcloud_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "springcloud_demo.mapper")
public class PaymentService8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentService8002.class,args);
    }
}
