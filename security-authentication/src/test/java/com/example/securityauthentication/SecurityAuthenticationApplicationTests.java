package com.example.securityauthentication;


import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootTest
public class SecurityAuthenticationApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void test1() {
        //对原始密码加密
//        String hashPw = BCrypt.hashpw("feiyu@123456", BCrypt.gensalt());
//        System.out.println(hashPw);
//        System.out.println(BCrypt.checkpw("feiyu@123456", "$2a$10$Y0ex3MO.d3cOkCukUa8lQeXJZ69/yGDEuo1HZQyFHanz2VnX.JHia"));
        System.out.println(BCrypt.hashpw("feiyu@123456", "$2a$10$Y0ex3MO.d3cOkCukUa8lQeXJZ69/yGDEuo1HZQyFHanz2VnX.JHia"));
    }

}
