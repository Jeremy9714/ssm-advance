package com.example.cloud.service;

import com.example.cloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/21 12:12
 * @Version: 1.0
 */
@Component
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping("/storage/decrease")
    CommonResult<?> decreaseStock(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
