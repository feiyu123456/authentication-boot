package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author jianping.yu@karakal.com.cn
 * @version 1.0
 * @date 2023/3/22
 **/
@Slf4j
@RestController
public class UserController {

    @PostMapping(value = "/login_success")
    public String loginSuccess(HttpSession session){
        return " 登录成功";
    }

    @PostMapping(value = "/login_out_time")
    public String loginOutTime() {
        return "登录超时";
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
    /**
     * 测试资源3
     * @return
     */
    @GetMapping(value = "/r/r3")
    public String r3(){
        return " 访问资源3";
    }

    /**
     * 测试资源4
     * @return
     */
    @GetMapping(value = "/r/r4")
    public String r4(){
        return " 访问资源4";
    }
}
