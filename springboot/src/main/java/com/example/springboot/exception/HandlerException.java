package com.example.springboot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: HandlerException
 * @Description:
 * @Author: 阿康
 * @DateTime: 2020/4/3016:57
 */
@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(value = {java.lang.NullPointerException.class})
    public ModelAndView testExceptionHandler(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception",e);
        modelAndView.setViewName("error1");
        return modelAndView;
    }

    /**
     * 数学异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
    public ModelAndView testExceptionHandler2(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception",e);
        modelAndView.setViewName("error2");
        return modelAndView;
    }

}
