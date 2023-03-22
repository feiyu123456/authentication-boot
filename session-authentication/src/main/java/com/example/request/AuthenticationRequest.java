package com.example.request;

import lombok.Data;

/**
 * @author jianping.yu@karakal.com.cn
 * @version 1.0
 * @date 2023/3/22
 **/
@Data
public class AuthenticationRequest {
    private String username;

    private String password;
}
