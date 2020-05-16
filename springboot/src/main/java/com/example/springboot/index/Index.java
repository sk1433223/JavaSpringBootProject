package com.example.springboot.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: IndexController
 * @Description:
 * @Author: 阿康
 * @DateTime: 2020/4/2410:38
 */
@Controller
@RequestMapping("/")
public class Index {

    @GetMapping(value = {"index","index.html"})
    public String demo() {
        System.out.println("index");
        return "index";
    }

}
