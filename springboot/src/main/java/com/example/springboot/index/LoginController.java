package com.example.springboot.index;

import com.example.springboot.model.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @ClassName: LoginController
 * @Description:
 * @Author: 阿康
 * @DateTime: 2020/5/1517:08
 */

@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping(value = {"","login.html","login"})
    public String getLogin() {
        return "login";
    }

    /**
     * login信息提交
     * @param userEntity
     * @return
     */
    @PostMapping(value = "loginCommit")
    public String login(UserEntity userEntity, HttpSession session) {
        if (userEntity!=null){
            if (userEntity.getUserName().equals("") | userEntity.getUserName()==null) {
                return "login";
            }
            if (userEntity.getPassWord().equals("") | userEntity.getPassWord()==null) {
                return "login";
            }
            String userName = userEntity.getUserName();
            String passWord = userEntity.getPassWord();
            if (userName.equals("user") & passWord.equals("pass")){
                session.setAttribute("userEntity",userEntity);

                return "success";
            }else {
                return "login";
            }
        }
        return "login";
    }

}
