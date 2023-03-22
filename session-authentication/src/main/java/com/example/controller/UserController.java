package com.example.controller;

import com.example.dto.UserDto;
import com.example.request.AuthenticationRequest;
import com.example.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author jianping.yu@karakal.com.cn
 * @version 1.0
 * @date 2023/3/22
 **/
@RestController
public class UserController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value = "/login")
    public String toLogin(AuthenticationRequest authenticationRequest, HttpSession session) {
        UserDto dto = authenticationService.authentication(authenticationRequest);
        session.setAttribute(UserDto.SESSION_USER_KEY, dto);
        return dto.getUsername() + "登录成功";
    }

    @GetMapping(value = "logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "退出成功";
    }

    /**
     * 测试资源1
     * @param session
     * @return
     */
    @GetMapping(value = "/r/r1")
    public String r1(HttpSession session){
        String fullname = null;
        Object userObj = session.getAttribute(UserDto.SESSION_USER_KEY);
        if(userObj != null){
            fullname = ((UserDto)userObj).getFullName();
        }else{
            fullname = "匿名";
        }
        return fullname + " 访问资源1";
    }

    

    @GetMapping("/queryUserInfo")
    public Object queryUserInfo(String userName) {
        return null;
    }
}
