package com.kenhome.server.service.test.impl;

import com.kenhome.server.service.test.TestService;
import org.springframework.stereotype.Service;

/**
 * @Author cmk
 * @Description
 * @Date 2018\9\16 0016 23:07
 */

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String test(String username) {
        System.out.println(username);
        return username;
    }
}
