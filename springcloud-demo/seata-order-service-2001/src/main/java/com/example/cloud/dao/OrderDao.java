package com.example.cloud.dao;

import com.example.cloud.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/21 11:53
 * @Version: 1.0
 */
@Mapper
public interface OrderDao {

    /**
     * 创建订单
     *
     * @param order
     */
    void create(Order order);

    /**
     * 修改订单状态
     *
     * @param userId
     */
    void update(@Param("userId") Long userId);
}
