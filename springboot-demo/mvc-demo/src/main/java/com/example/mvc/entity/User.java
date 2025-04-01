package com.example.mvc.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: Chenyang on 2025/02/27 21:50
 * @Version: 1.0
 */
@Data
public class User implements Serializable {
    private String name;
    private Integer age;
    private String gender;
}
