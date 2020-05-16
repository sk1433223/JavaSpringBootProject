package com.example.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName: DemoController
 * @Description:
 * @Author: 阿康
 * @DateTime: 2020/4/3017:10
 */
public class DemoController {

    @GetMapping("/demo")
    public void demo () {
        System.out.println(1/0);
    }
}
