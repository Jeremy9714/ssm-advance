package com.example.plugins.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.plugins.handler.impl.DocHandler;
import com.example.plugins.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Author: Chenyang on 2025/03/31 9:19
 * @Version: 1.0
 */
@RequestMapping("/poi")
@Controller
public class PoiController {

    @Autowired
    private ITestService testService;

    @RequestMapping("/index")
    public String index() {
        return "/index";
    }

    @RequestMapping("/exportExcel")
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) {
        String type = request.getParameter("type");
        if ("employee".equals(type)) {
            new DocHandler().exportDataExcel(response);
        }
    }

    @RequestMapping("/importExcel")
    @ResponseBody
    public String importExcel(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "type") String type) {
        long start = 0;
        long end = 0;
        JSONObject json = new JSONObject();

        if ("employee".equals(type)) {
            try {
                start = System.currentTimeMillis();
                new DocHandler().importDataExcel(file);
                end = System.currentTimeMillis();
            } catch (RuntimeException e) {
                System.out.println("====== 导入失败，" + e.getMessage() + " ======");
                json.put("state", 0);
                json.put("msg", "导入失败，" + e.getMessage());
                return json.toJSONString();
            }
        }

        System.out.println("导入成功，耗时 " + (end - start) / 1000 + "s");
        json.put("state", 1);
        json.put("msg", "导入成功");
        return json.toJSONString();
    }

    @GetMapping("/thread")
    public void threadTest() {
        testService.sayHello();
        testService.sayHello();
        testService.sayHello();
        testService.sayHello();
        testService.sayHello();
        testService.sayHello();
//        testService.sayHello();

        testService.sayHi();
        testService.sayHi();
        testService.sayHi();
        testService.sayHi();
        testService.sayHi();
        testService.sayHi();
    }
}
