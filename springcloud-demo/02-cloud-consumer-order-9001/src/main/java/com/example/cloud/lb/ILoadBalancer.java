package com.example.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/16 11:50
 * @Version: 1.0
 */
public interface ILoadBalancer {

    ServiceInstance getInstance(List<ServiceInstance> instances);
}
