package com.example.springboot.index;

import com.example.springboot.model.UserEntity;
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

    @GetMapping(value = {"index", "index.html"})
    public String demo() {

        log.info("info日志打印");
        log.debug("debug日志打印");
        return "index";
    }

    @GetMapping(value = {"test"})
    public String demoLogin(UserEntity user) {
        if (user.getUserName().equals("user") & user.getPassWord().equals("pass")) {
            return "index";
        }
        return "login";
    }

}
