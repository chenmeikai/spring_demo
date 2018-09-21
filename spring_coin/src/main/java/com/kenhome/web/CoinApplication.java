package com.kenhome.web;

import com.kenhome.server.mapper.MapperRoot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages ="com.kenhome")
@MapperScan(basePackageClasses = MapperRoot.class)
public class CoinApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoinApplication.class, args);
    }
}