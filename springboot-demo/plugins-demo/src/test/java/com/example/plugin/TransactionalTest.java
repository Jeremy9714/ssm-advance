package com.example.plugin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.plugins.MainApplication;
import com.example.plugins.bean.DatasourceBean;
import com.example.plugins.bean.DocBean;
import com.example.plugins.service.DatasourceService;
import com.example.plugins.service.DocService;
import com.example.plugins.util.GlobalUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * @Description:
 * @Author: Chenyang on 2025/03/31 15:28
 * @Version: 1.0
 */
@SpringBootTest(classes = MainApplication.class)
public class TransactionalTest {

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private DocService docService;

    @Autowired
    private DatasourceService datasourceService;

    @Test
    public void test1() {
        LambdaQueryWrapper<DocBean> wrapper = new LambdaQueryWrapper<>();
        List<DocBean> list = docService.list(wrapper);
        list.forEach(System.out::println);
    }

    /**
     * 基于PlatformTransactionManager对事务的控制实现
     */
    @Test
    public void transactionManagerTest() {
        // 事务基础信息 超时时间、隔离级别、传播属性等
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        // 设置传播行为属性，默认事务级别(当前无事务则新建事务，已有事务则加入事务)
        def.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
        // 获取事务状态
        TransactionStatus status = transactionManager.getTransaction(def);

        try {
            System.out.println("执行事务方法");
            DocBean bean = DocBean.builder().id("10")
                    .name("Jason")
                    .age(30)
                    .gender("M")
                    .address("LN7 7DB")
                    .job("2")
                    .build();
            docService.save(bean);

            int i = 1 / 0;
            transactionManager.commit(status); // 提交事务
            System.out.println("提交完成");
        } catch (Exception e) {
            transactionManager.rollback(status);
            System.out.println("错误，回滚");
        }
    }

    /**
     * 基于TransactionTemplate对事务的控制实现
     */
    @Test
    public void transactionTemplateTest() {
        transactionTemplate.execute(new TransactionCallback<String>() {
            @Override
            public String doInTransaction(TransactionStatus status) {
                try {
                    System.out.println("执行事务方法");
                    DocBean bean = DocBean.builder().id("10")
                            .name("Jason")
                            .age(30)
                            .gender("M")
                            .address("LN7 7DB")
                            .job("2")
                            .build();
                    docService.save(bean);

                    // 手动设置异常
                    int i = 1 / 0;
                    System.out.println("提交完成");
                    return "成功";
                } catch (Exception e) {
                    System.out.println("错误，回滚");
                    status.setRollbackOnly();
                    return "失败";
                }
            }
        });
    }

    /**
     * 声明式事务
     */
    @Test
    @Transactional(rollbackFor = Exception.class)
    public void transactionalTest() {
        try {
            DocBean bean = DocBean.builder().id("10")
                    .name("Jason")
                    .age(30)
                    .gender("M")
                    .address("LN7 7DB")
                    .job("2")
                    .build();
            docService.save(bean);

            // 手动设置异常
            int i = 1 / 0;
            System.out.println("提交完成");
        } catch (Exception e) {
            System.out.println("错误，回滚");
            // 如果异常被try、catch吞了是不会回滚的，需要手动抛出
            throw e;
        }
    }

    @Test
    public void txTest1() {
        DocBean doc = DocBean.builder().id(GlobalUtils.getUUID())
                .name("Melissa")
                .age(30)
                .gender("F")
                .address("Malaysia")
                .job("2")
                .build();
//        docService.saveOne(doc);

        DatasourceBean ds = DatasourceBean.builder().name("ds1")
                .dbType("mysql")
                .host("k8s-master")
                .username("root")
                .password("9714")
                .build();
        datasourceService.saveAndDelete(ds, doc);
    }
}
