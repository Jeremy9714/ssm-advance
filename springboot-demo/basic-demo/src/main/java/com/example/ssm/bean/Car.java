package com.example.ssm.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description:
 * @Author: Chenyang on 2025/02/27 16:05
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "car")
public class Car {
    private String brand;
    private int price;
    private String productDetail;
}
