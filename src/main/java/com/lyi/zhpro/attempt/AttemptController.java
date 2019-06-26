package com.lyi.zhpro.attempt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: zhpro
 * @description: 尝试
 * @author: LYI
 * @create: 2019-06-18 11:37
 **/
@Controller
public class AttemptController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        System.out.println("hello SpringBoot");
        return "hello SpringBoot";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
