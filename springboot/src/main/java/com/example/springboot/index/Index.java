package com.example.springboot.index;

import com.example.springboot.model.UserEntity;
import com.example.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @DateTime: 2020/4/24 10:38
 * @ClassName: IndexController
 * @description:
 * @author 阿康
 *
 */
@Controller
@RequestMapping("/")
@Slf4j
public class Index {

    private final UserService userService;

    @Autowired
    public Index(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"index", "index.html"})
    public String indexHtml() {

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
