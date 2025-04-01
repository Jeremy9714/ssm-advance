package com.example.mvc.controller;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: Chenyang on 2025/02/27 21:57
 * @Version: 1.0
 */
@RestController
public class ParameterController {

    @RequestMapping("/user/{name}/gender/{gender}")
    public Map<String, String> getUser(@PathVariable("name") String name,
                                       @PathVariable("gender") String gender,
                                       @PathVariable Map<String, String> paramMap,
                                       @RequestHeader("User-Agent") String header,
                                       @RequestHeader MultiValueMap<String, String> headers,
                                       @CookieValue("JSESSIONID") String sessionId,
                                       @CookieValue("JSESSIONID") Cookie cookie
    ) {
        Map<String, String> map = new HashMap<>();
        System.out.println(name + "\t" + gender);
        System.out.println("User-Agent=" + header);
        System.out.println("headers:" + headers);
        System.out.println("JSESSIONID=" + sessionId);
        System.out.println(cookie);
        map.putAll(paramMap);
        return map;
    }


    @PostMapping("/post/user/form")
    public Map<String, Object> postUserForm(@RequestParam Map<String, Object> content) {
        // Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported
        return content;
    }

    @PostMapping("/post/user/json")
    public Map<String, Object> postUserJson(@RequestBody String content) {
        Map<String, Object> map = new HashMap<>();
        map.put("content", content);
        return map;
    }

    @GetMapping("/users/{path1}/{path2}")
    public Map userInfo(@PathVariable("path1") String path1,
                          @PathVariable("path2") String path2,
                          @MatrixVariable(value = "name", pathVar = "path1") String name,
                          @MatrixVariable(value = "num", pathVar = "path2") List<Integer> nums) {
        Map<String, Object> map = new HashMap<>();
        map.put("path1", path1);
        map.put("path2", path2);
        map.put("name", name);
        map.put("nums", nums);
        return map;
    }

}
