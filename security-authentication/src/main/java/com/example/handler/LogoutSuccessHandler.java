package com.example.handler;

import com.alibaba.fastjson.JSON;
import com.example.dto.SecurityWebServiceResult;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author jianping.yu@karakal.com.cn
 * @version 1.0
 * @date 2023/3/30
 **/
public class LogoutSuccessHandler implements org.springframework.security.web.authentication.logout.LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setStatus(HttpStatus.OK.value());
        SecurityWebServiceResult result = SecurityWebServiceResult.ok(null).message("登出成功");
        // 写入response
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(JSON.toJSONString(result));
        writer.flush();
        writer.close();
    }
}
