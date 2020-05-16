package com.example.springboot.index;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class Index {

    @GetMapping(value = {"index","index.html"})
    public String demo() {

        log.info("info日志打印");
        log.debug("debug日志打印");
        System.out.println("index");
        return "index";
    }

}
