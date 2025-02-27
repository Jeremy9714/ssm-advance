package com.example.mybatis.mapper;

import com.example.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: Chenyang on 2025/02/26 20:47
 * @Version: 1.0
 */
public interface EmployeeMapper {

    List<Employee> getList();

    Employee getEmp(@Param("eid") String id);

    Employee getEmployeeAndStaff(@Param("eid") String id);

    Employee getEmployeeAndStaffStep(@Param("eid") String id);

}
