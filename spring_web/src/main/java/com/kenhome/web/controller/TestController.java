package com.kenhome.web.controller;

import com.kenhome.common.constant.universal.ResponseEnum;
import com.kenhome.common.entity.account.User;
import com.kenhome.common.model.universal.ResponseModel;
import com.kenhome.server.mapper.account.UserMapper;
import com.kenhome.server.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("success")
    public ResponseModel success(){
        return ResponseModel.success();
    }

    @GetMapping("success1")
    public ResponseModel<Map<String,Object>> success(String name,Integer age){
        Map<String,Object> data =new HashMap<>();
        data.put("name",name);
        data.put("age",age);
        return ResponseModel.success(data);
    }

    @GetMapping("fail")
    public ResponseModel fail(){
        return ResponseModel.fail(ResponseEnum.NECESSARY_PARAMETERS);
    }

    @GetMapping("fail1")
    public ResponseModel fail(String name,Integer age){
        return ResponseModel.failWithParameters(ResponseEnum.NO_ENOUGH_AGE,name,age);
    }

}
