package com.example.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Description: 订单
 * @Author: Chenyang on 2025/04/21 11:34
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    
    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private BigDecimal money;
    
    // 订单状态 0创建中 1已完成
    private Integer status;
}
