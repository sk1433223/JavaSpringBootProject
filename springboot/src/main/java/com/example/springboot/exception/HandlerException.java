package com.example.springboot.exception;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

/**
 * @author 阿康
 * @ClassName: HandlerException
 * @DateTime: 2020/4/3016:57
 */
@Slf4j
@ControllerAdvice
public class HandlerException {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 空指针异常
     */
    @ExceptionHandler(value = {java.lang.NullPointerException.class})
    public ModelAndView testExceptionHandler(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.setViewName("error/error1");
        log.info("Message:"+e.getMessage());
        return modelAndView;
    }

    /**
     * 数学异常
     */
    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
    public ModelAndView testExceptionHandler2(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        // 跳转指定路径页面
        modelAndView.setViewName("error/error2");
        log.info("Message:"+e.getMessage());
        log.info("StackTrace:"+ Arrays.toString(e.getStackTrace()));
        log.info("getClass:"+e.getClass());
        return modelAndView;
    }

}
