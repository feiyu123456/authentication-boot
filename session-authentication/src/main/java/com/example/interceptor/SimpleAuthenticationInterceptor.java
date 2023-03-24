package com.example.interceptor;

import com.example.dto.UserDto;
import com.example.entity.RoleEntity;
import com.example.repository.IRoleEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @author jianping.yu@karakal.com.cn
 * @version 1.0
 * @date 2023/3/22
 **/
@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private IRoleEntityRepository roleEntityRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //读取会话
        Object object = request.getSession().getAttribute(UserDto.SESSION_USER_KEY);
        if (object == null) {
            writeContent(response, "请登录");
            return false;
        }
        UserDto userDto = (UserDto) object;
        List<RoleEntity> list = roleEntityRepository.findRoleEntitiesByUserId(userDto.getId());
        if (list != null && list.size() > 0) {
            StringBuilder s = new StringBuilder();
            list.stream().forEach(e -> s.append(e.getAuth()));
            writeContent(response, s.toString());
            return true; 
        }
        writeContent(response, "权限不足，拒绝访问");
        return false;
    }

    //响应输出
    private void writeContent(HttpServletResponse response, String msg) throws IOException {
        response.setCharacterEncoding("utf-8");
        //PrintWriter writer = response.getWriter();
        Writer writer = new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));
        writer.write(msg);
        writer.close();
        response.reset();
    }
}
