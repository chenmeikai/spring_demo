package com.kenhome.web.controller;

import com.kenhome.common.entity.account.User;
import com.kenhome.server.mapper.account.UserMapper;
import com.kenhome.server.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author cmk
 * @Description
 * @Date 2018\9\16 0016 21:40
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("test")
    public String test(String username){


        return testService.test(username);
    }

    @GetMapping("save")
    public String save(String username,String password,String phone){
        return testService.save(username,password,phone);
    }
}
