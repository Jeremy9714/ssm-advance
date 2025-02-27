package com.example.mybatis.test;

import com.example.mybatis.bean.Employee;
import com.example.mybatis.bean.Staff;
import com.example.mybatis.bean.Teacher;
import com.example.mybatis.bean.User;
import com.example.mybatis.mapper.EmployeeMapper;
import com.example.mybatis.mapper.StaffMapper;
import com.example.mybatis.mapper.TeacherMapper;
import com.example.mybatis.mapper.UserMapper;
import com.example.mybatis.util.SqlSessionUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @Author: Chenyang on 2025/02/26 16:58
 * @Version: 1.0
 */
public class MybatisTest_01 {

    @Test
    public void testMybatis() throws Exception {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        User user = new User("user01", "Jeremy", 28, "male");
//        int result = mapper.insertUser(user);
//        sqlSession.commit();
//        if (result != 0) {
//            System.out.println(mapper.queryUser("user01"));
//        }

//        mapper.queryList("Jeremy", 28).forEach(System.out::println);
//        System.out.println(mapper.getAllUserToMap());
//        mapper.queryList2("e").forEach(System.out::println);
//        mapper.queryList3(Arrays.asList("user01", "user02")).forEach(System.out::println);
        mapper.getUserByCondition(new HashMap<String, Object>() {{
            put("id", "user01");
        }}).forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void mybatisTest2() throws IOException {
        TeacherMapper mapper = SqlSessionUtils.getSqlSession().getMapper(TeacherMapper.class);
        Teacher teacher = new Teacher(null, "Jason");
        mapper.insertTeacher(teacher);
        System.out.println(teacher);
    }

    @Test
    public void mybatisTest3() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        mapper.getList().forEach(System.out::println);
//        System.out.println(mapper.getEmployeeAndStaff("e1"));
        System.out.println(mapper.getEmployeeAndStaffStep("e1"));
    }

    @Test
    public void mybatisTest4() throws IOException {
        StaffMapper mapper = SqlSessionUtils.getSqlSession().getMapper(StaffMapper.class);
//        mapper.getList().forEach(System.out::println);
        Staff staff = mapper.getListForStep().get(0);
        System.out.println(staff.getStaffName());
        System.out.println("===================");
        Employee employee = staff.getEmployee();
        System.out.println(employee.getEmpName());
        System.out.println("===================");
        System.out.println(employee);
    }

    @Test
    public void mybatisTest5() throws Exception {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);

        System.out.println(sqlSession1.getMapper(UserMapper.class).queryUser("user01"));
        // 二级缓存在sqlSession提交或者关闭时才生效
        sqlSession1.close();
        System.out.println("=========================");
        System.out.println(sqlSession2.getMapper(UserMapper.class).queryUser("user01"));
    }

    @Test
    public void mybatisTest6() throws IOException {
        UserMapper mapper = SqlSessionUtils.getSqlSession().getMapper(UserMapper.class);
        PageHelper.startPage(1, 4);
        List<User> userList = mapper.queryAll();
//        userList.forEach(System.out::println);

        PageInfo<User> userPageInfo = new PageInfo<>(userList, 3);
        System.out.println(userPageInfo);
    }
}
