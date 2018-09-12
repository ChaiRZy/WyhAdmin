package com.feri.wyh10000.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2018/9/12 10:24
 */
@RestController
public class HelloController {

    @GetMapping("/hello.do")
    public String hello(){
        System.out.println("请求来了");
        return "下课了";
    }
}
