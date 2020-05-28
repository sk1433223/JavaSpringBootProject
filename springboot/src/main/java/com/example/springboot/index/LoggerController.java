package com.example.springboot.index;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: LoggerController
 * @Description: logger
 * (1)
 * springboot 可以使用注解 @Slf4j 的方式直接调用 log
 * 控制台显示信息依次为: 时间;日志级别;进程ID;分隔符;线程名[ main];Logger名：通常使用源代码的类名;日志内容
 * 日志级别(一般分为四种) ERROR、WARN、INFO、DEBUG (只输出大于及等于的级别的日志)(springboot默认info级别)
 * (2)
 * 默认情况下，Spring Boot将日志输出到控制台，不会写到日志文件。
 * application只能配置简单的场景，保存路径、日志格式等，复杂的场景（区分 info 和 error 的日志、每天产生一个日志文件等）满足不了，只能自定义配置
 * @Author: 阿康
 * @DateTime: 2020/5/1617:49
 */
@Controller
public class LoggerController {

    /**
     * ERROR、WARN、INFO、DEBUG
     */
    private final Logger log = LoggerFactory.getLogger(getClass());

    @ResponseBody
    @GetMapping("/logger1")
    public String loggerTest() {
        log.debug("hello debug!");
        log.info("hello logger!");
        log.warn("hello warn!");
        log.error("hello error");
        return "Logger";
    }

}
