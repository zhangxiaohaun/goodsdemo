package com.cskt.zxh.goodsdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cskt.zxh.goodsdemo.mapper")
public class GoodsdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsdemoApplication.class, args);
    }

}
