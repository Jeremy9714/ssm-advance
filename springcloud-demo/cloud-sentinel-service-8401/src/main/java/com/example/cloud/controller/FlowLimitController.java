package com.example.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Chenyang on 2025/04/19 16:34
 * @Version: 1.0
 */
@Slf4j
@RequestMapping("/flow")
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "------ testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t testB");
        return "------ testB";
    }

    @GetMapping("/testC")
    public String testC() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(Thread.currentThread().getName() + "\t testC 测试RT降级");
        return "------ testC";
    }

    @GetMapping("/testD")
    public String testD() {
        log.info("testD 测试异常率");
        int a = 10 / 0;
        return "------ testD";
    }

    @RequestMapping("/testE")
    public String testE() {
        log.info("testE 测试异常数");
        int a = 10 / 0;
        return "------ testE";
    }

    @GetMapping("/testHotKeys")
    // @SentinelResource 资源名、降级调用方法指定
    @SentinelResource(value = "testHotKeys", blockHandler = "hotKeyHandler")
    public String testHotKeys(@RequestParam(value = "p1", required = false) String p1,
                              @RequestParam(value = "p2", required = false) String p2) {
        // @SentinelResource 主管控制台配置的违规情况，代码运行错误不会走降级方法
//        int a = 10 / 0;
        return "----- testHotKeys 测试热点参数限流";
    }

    // 限流后调用的方法
    public String hotKeyHandler(String p1, String p2, BlockException be) {
        return "------ hotKeyHandler";
    }
}
