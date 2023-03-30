package com.example.service;

import com.example.entity.UserEntity;
import com.example.repository.IUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author jianping.yu@karakal.com.cn
 * @version 1.0
 * @date 2023/3/29
 **/
@Component
public class SpringDataUserDetailsService implements UserDetailsService {

    @Resource
    IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserEntity> opt = userRepository.findByUserName(username);
        if (!opt.isPresent()) return null; //如果查不到用户，就返回null,由provider抛出异常
        UserEntity user = opt.get();
        //查询用户权限
        List<String> permissions =userRepository.queryPermissionsByUserId(user.getId());
        String[] permissionArray = new String[permissions.size()];
        permissions.toArray(permissionArray);
        //创建userDetails
        UserDetails userdetails = User.withUsername(user.getUserName()).password(user.getPassWord()).authorities(permissionArray).build();
        return userdetails;
    }

}
