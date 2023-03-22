package com.example.service.impl;

import com.example.dto.UserDto;
import com.example.entity.UserEntity;
import com.example.repository.IUserEntityRepository;
import com.example.request.AuthenticationRequest;
import com.example.service.AuthenticationService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @author jianping.yu@karakal.com.cn
 * @version 1.0
 * @date 2023/3/22
 **/
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Resource
    private IUserEntityRepository userEntityRepository;

    @Override
    public UserDto authentication(AuthenticationRequest authenticationRequest) {
        if (authenticationRequest == null
                || StringUtils.isEmpty(authenticationRequest.getUsername())
                || StringUtils.isEmpty(authenticationRequest.getPassword())) throw new RuntimeException("账号或密码为空");
        UserEntity userEntity = userEntityRepository.findUserEntityByName(authenticationRequest.getUsername());
        if (userEntity == null) throw new RuntimeException("查询不到该用户");
        if (!authenticationRequest.getPassword().equals(userEntity.getPassWord())) throw new RuntimeException("密码错误！");
        return userEntity.userEntityMapUserDto();
    }
}
