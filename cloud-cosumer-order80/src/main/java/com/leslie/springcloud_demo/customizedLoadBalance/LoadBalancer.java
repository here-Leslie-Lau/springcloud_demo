package com.leslie.springcloud_demo.customizedLoadBalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {

    //自定义轮询算法
    public ServiceInstance choose(List<ServiceInstance> instances);
}
