package com.example.config;

import com.example.service.SpringDataUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.annotation.Resource;

/**
 * @author jianping.yu@karakal.com.cn
 * @version 1.0
 * @date 2023/3/24
 **/
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Resource
//    private SpringDataUserDetailsService springDataUserDetailsService;

    //定义用户信息
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return springDataUserDetailsService;
//    }

    //密码编码器
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    //安全拦截机制
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() //禁用跨站请求仿造
                .authorizeRequests()
                .antMatchers("/r/r1").hasAuthority("p1")
                .antMatchers("/r/r2").hasAuthority("p2")
                .antMatchers("/r/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin() //允许表单登录
                .loginPage("/login-view")
                .loginProcessingUrl("/doLogin") //指定登录处理的url 也就是用户名密码表单提交的目的路径
                .defaultSuccessUrl("/login")
                .successForwardUrl("/login_success") //指定登录成功后跳转的url
                .permitAll();
                
    }
}
