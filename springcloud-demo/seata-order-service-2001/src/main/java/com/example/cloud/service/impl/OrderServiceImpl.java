package com.example.cloud.service.impl;

import com.example.cloud.dao.OrderDao;
import com.example.cloud.entity.Order;
import com.example.cloud.service.AccountService;
import com.example.cloud.service.OrderService;
import com.example.cloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/21 12:10
 * @Version: 1.0
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    @GlobalTransactional(name = "create-order-tx", rollbackFor = Exception.class)
    @Override
    public void create(Order order) {
        // 创建订单
        log.info("------ Creating new order");
        orderDao.create(order);

        // 修改库存
        log.info("------ Invoking storageService");
        storageService.decreaseStock(order.getProductId(), order.getCount());

        // 修改余额
        log.info("------ Invoking accountService");
        accountService.decrease(order.getUserId(), order.getMoney());

        // 完成订单
        log.info("------ Updating order status");
        orderDao.update(order.getUserId());

        log.info("完成订单: {}", order);
    }
}
