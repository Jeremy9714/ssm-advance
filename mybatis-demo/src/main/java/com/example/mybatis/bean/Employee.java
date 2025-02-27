package com.example.mybatis.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description:
 * @Author: Chenyang on 2025/02/26 20:46
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String eid;
    private String empName;
    private int age;
    private String gender;
    private List<Staff> staffs;
}
