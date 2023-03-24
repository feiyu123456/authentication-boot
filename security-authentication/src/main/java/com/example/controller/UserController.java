package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author jianping.yu@karakal.com.cn
 * @version 1.0
 * @date 2023/3/22
 **/
@Slf4j
@RestController
public class UserController {

    @PostMapping(value = "/login_success")
    public String loginSuccess(){
        return " 登录成功";
    }

    /**
     * 测试资源1
     * @return
     */
    @GetMapping(value = "/r/r1")
    public String r1(){
        return " 访问资源1";
    }
    /**
     * 测试资源2
     * @return
     */
    @GetMapping(value = "/r/r2")
    public String r2(){
        return " 访问资源2";
    }
}
