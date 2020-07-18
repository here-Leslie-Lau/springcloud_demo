package com.leslie.springcloud_demo.customizedLoadBalance.impl;

import com.leslie.springcloud_demo.customizedLoadBalance.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class CustomizedLoadBalancer implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public ServiceInstance choose(List<ServiceInstance> instances) {
        int index = getNext() % instances.size();

        return instances.get(index);
    }

    //获得访问次数，用cas与自旋锁控制并发
    public Integer getNext(){

        int current;
        int next;

        do {

            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;

        }while (!atomicInteger.compareAndSet(current,next));

        log.info("********第几次访问:"+next);

        return next;
    }
}
