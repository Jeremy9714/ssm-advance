package com.example.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: Chenyang on 2025/02/27 22:35
 * @Version: 1.0
 */
@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request) {
        request.setAttribute("token", "123");
        return "forward:/target";
    }

    @GetMapping("/target")
    @ResponseBody
    public String targetPage(@RequestAttribute("token") String token) {
        return token;
    }

    @GetMapping("/param/from")
    public String paramFrom(Map<String, Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        map.put("code", 200);
        model.addAttribute("msg", "success");
        request.setAttribute("data", "null");
        response.addCookie(new Cookie("k1", "v1"));
        return "forward:/param/to";
    }

    @GetMapping("/param/to")
    @ResponseBody
    public Map<String, Object> paramTo(@RequestAttribute("code") Integer code,
                                       @RequestAttribute("msg") String msg,
                                       HttpServletRequest request) {
        Object data = request.getAttribute("data");
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", data);
        return map;
    }
}
