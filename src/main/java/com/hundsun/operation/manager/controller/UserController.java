package com.hundsun.operation.manager.controller;

import com.hundsun.operation.manager.mapper.UserMapper;
import com.hundsun.operation.manager.model.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: maintenance
 * @description:
 * @author: chuangkel
 * @create: 2019-01-16
 **/
@RestController
@RequestMapping("rest/user")

public class UserController {

    private UserMapper userMapper;
    public UserController(UserMapper userMapper){
        this.userMapper = userMapper;
    }
    @GetMapping("/all")
    public List<Users> findAllUsers(){
        return userMapper.findAll();
    }
    @GetMapping("/add")
    public void insertUsers(){
        Users users = new Users();
        users.setName("John");
        users.setSalary(30000L);
        userMapper.insert(users);
    }
}
