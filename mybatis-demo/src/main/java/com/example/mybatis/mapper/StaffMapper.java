package com.example.mybatis.mapper;

import com.example.mybatis.bean.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:
 * @Author: Chenyang on 2025/02/26 21:01
 * @Version: 1.0
 */
public interface StaffMapper {
    List<Staff> getList();

    List<Staff> getListForStep();

    Staff getStaff(@Param("eid") String id);
}
