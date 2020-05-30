package com.example.springboot.index;

import com.example.springboot.model.UserEntity;
import com.example.springboot.service.UserService;
import com.example.springboot.web.CodeUtil;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * @ClassName LoginController
 * @description:
 * @author 阿康
 * @DateTime: 2020/5/1517:08
 */

@Controller
@RequestMapping("/")
public class LoginController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final UserService userService;

    private final Producer kaptchaProducer;

    private final Producer captchaProducer;


    @Autowired
    public LoginController(UserService userService, Producer kaptchaProducer, Producer captchaProducer) {
        this.userService = userService;
        this.kaptchaProducer = kaptchaProducer;
        this.captchaProducer = captchaProducer;
    }

    @RequestMapping(value = {"", "login.html", "login"})
    public String getLogin() {
        return "login";
    }


    @RequestMapping(value = "verifyImg")
    public String getVerify() {
        return "hello";
    }

    /**
     * login信息提交(登陆验证)
     */
    @PostMapping(value = "loginCommit")
    public String login(UserEntity userEntity, HttpSession session,HttpServletRequest request,String verifyCodeActual) {
        if (userEntity != null) {
            if ("".equals(userEntity.getUserName()) | userEntity.getUserName() == null) {
                return "login";
            }
            if ("".equals(userEntity.getPassWord()) | userEntity.getPassWord() == null) {
                return "login";
            }
            if("".equals(verifyCodeActual) | verifyCodeActual == null) {
                return "login";
            }
            // 校正验证码
            if (!CodeUtil.checkVerifyCode(request)) {
                return "login";
            }
            String userName = userEntity.getUserName();
            String passWord = userEntity.getPassWord();
            UserEntity userByUserName = userService.getUserByUserName(userName);
            if (userByUserName != null) {
                if (userName.equals(userByUserName.getUserName()) & passWord.equals(userByUserName.getPassWord())) {
                    session.setAttribute("userEntity", userEntity);
                    return "success";
                } else {
                    return "login";
                }
            }
        }
        return "login";
    }

    @GetMapping(value = {"loginDemo"})
    public String demoLogin(UserEntity user) {
        if ("user".equals(user.getUserName()) & "pass".equals(user.getPassWord())) {
            return "index";
        }
        return "login";
    }


    /**
     * 生成验证码
     * @param request 请求
     * @param response 响应
     */
    @RequestMapping("/kaptcha")
    public void getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        //生成验证码
        String capText = captchaProducer.createText();
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        //向客户端写出
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }

    @PostMapping("hello")
    @ResponseBody
    public String hello(HttpServletRequest request) {
        if (!CodeUtil.checkVerifyCode(request)) {
            return "hello";
        } else {
            return "验证码正确!";
        }
    }

    @GetMapping("loginOut")
    public String loginOut(HttpServletRequest request) {
        request.getSession().removeAttribute("userEntity");
        return "login";
    }

}
