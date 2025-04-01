package com.example.mvc.controller;

import com.example.mvc.entity.User;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * @Description:
 * @Author: Chenyang on 2025/02/27 17:23
 * @Version: 1.0
 */
@RestController
public class MvcController {

    @GetMapping("/user")
    public String getUser() {
        return "GET";
    }

    @PostMapping("/user")
    public String saveUser() {
        return "POST";
    }

    @PutMapping("/user")
    public String updateUser() {
        return "PUT";
    }

    @DeleteMapping("/user")
    public String deleteUser() {
        return "DELETE";
    }

//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    public String test(@RequestParam("name") String name, ModelMap modelMap) {
//        System.out.println(name);
//        return "hello";
//    }

    @RequestMapping("/save/user")
    public String saveFormUser(User user, HttpSession session) {
        System.out.println(user);
        return "success";
    }

    @GetMapping("/test")
    public String test(HttpServletRequest request) {
        StringBuffer sb = new StringBuffer();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String hName = headerNames.nextElement();
            sb.append(hName + ": " + request.getHeader(hName) + "<br>");
        }
        String remoteHost = request.getRemoteHost();
        int remotePort = request.getRemotePort();
        String remoteAddr = request.getRemoteAddr();
        sb.append("remoteHost: " + remoteHost + "<br>");
        sb.append("remotePort: " + remotePort + "<br>");
        sb.append("remoteAddr: " + remoteAddr + "<br>");

        String ipAddr = request.getHeader("x-forwarded-for");
        sb.append("idAddr: " + ipAddr);
        return sb.toString();
    }

}
