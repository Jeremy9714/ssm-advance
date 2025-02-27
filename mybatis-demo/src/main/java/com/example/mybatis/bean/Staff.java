package com.example.mybatis.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: Chenyang on 2025/02/26 21:00
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {

    private String id;
    private String staffName;
    private Employee employee;
}
