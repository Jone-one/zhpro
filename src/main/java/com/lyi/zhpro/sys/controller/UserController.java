package com.lyi.zhpro.sys.controller;

import com.lyi.zhpro.sys.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/index")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public Map login(String account, String pwd) {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(account, pwd);
        Subject subject = SecurityUtils.getSubject();
        Map map = new HashMap();
        try {
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e) {
            System.err.println("用户不存在");
            map.put("code", "0");
            map.put("msg", "用户不存在！");
            return map;
        } catch (IncorrectCredentialsException e) {
            System.err.println("密码错误");
            map.put("code", "1");
            map.put("msg", "密码错误！");
            return map;
        }
        map.put("code", "2");
        map.put("msg", "成功！");
       return map;
    }
}
