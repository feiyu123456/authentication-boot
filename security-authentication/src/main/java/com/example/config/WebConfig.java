package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author jianping.yu@karakal.com.cn
 * @version 1.0
 * @date 2023/3/22
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //访问上下文+/ 默认访问login.html页面 (这里主要进行=====认证)
        registry.addViewController("/").setViewName("redirect:/login");
    }
}
