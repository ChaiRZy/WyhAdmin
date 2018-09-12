package com.feri.wyh10000.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan("com.feri.wyh10000.admin.mapper")
public class WyhAdminApplication {

    public static void main(String[] args) {
        //启动
        SpringApplication.run(WyhAdminApplication.class, args);
    }
}
