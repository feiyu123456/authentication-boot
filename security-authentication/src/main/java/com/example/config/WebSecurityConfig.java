package com.example.config;

import com.example.handler.LogoutSuccessHandler;
import com.example.service.SpringDataUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        return new BCryptPasswordEncoder();
    }

    //安全拦截机制
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() //禁用跨站请求仿造
                .authorizeRequests()
                .antMatchers("/r/r1").hasAuthority("p1")
                .antMatchers("/r/r2").hasAuthority("p2")
                .antMatchers("/r/r3").access("hasAuthority('p1') and hasAuthority('p2')")
                .antMatchers("/r/r4").hasAuthority("p3")
                .antMatchers("/r/**").authenticated() //authenticated()保护url,需要用户登录
                /** !!! 默认其他请求都需要认证, 一定要添加 **/
                .anyRequest().permitAll() // permitAll() 指定url无需保护，一般应用与静态资源文件或登录
                .and()
                .formLogin() //允许表单登录
                .loginPage("/login-view")
                .loginProcessingUrl("/doLogin") //指定登录处理的url 也就是用户名密码表单提交的目的路径
                .defaultSuccessUrl("/login")
                .successForwardUrl("/login_success") //指定登录成功后跳转的url
                .permitAll()
                .and()
                .sessionManagement()
                //.invalidSessionUrl("/login-view?error=INVALID_SESSION")
                /**STATELESS不允许新建session，每次访问都要重新进行身份验证。**/
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login-view?logout")
                /**配置了logoutSuccessHandler() 那logoutSuccessUrl()就无效了**/
                .logoutSuccessHandler(new LogoutSuccessHandler())
                /**指定是否在退出时让 HttpSession 无效。 默认设置为 true。**/
                .invalidateHttpSession(true);
    }
}
