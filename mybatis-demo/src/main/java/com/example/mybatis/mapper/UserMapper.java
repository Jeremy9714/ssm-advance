package com.example.mybatis.mapper;

import com.example.mybatis.bean.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: Chenyang on 2025/02/26 16:43
 * @Version: 1.0
 */
public interface UserMapper {

    int insertUser(User user);

    User queryUser(String id);

    List<User> queryList(@Param("username") String name, @Param("userage") int age);

    @MapKey("id")
    Map<String, Object> getAllUserToMap();

    List<User> queryList2(String name);
    
    List<User> queryList3(List<String> ids);
    
    List<User> getUserByCondition(Map<String,Object> paramMap);
    
    List<User> queryAll();
}
