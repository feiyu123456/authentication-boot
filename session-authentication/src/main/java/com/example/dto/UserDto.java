package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jianping.yu@karakal.com.cn
 * @version 1.0
 * @date 2023/3/22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
     public static final String SESSION_USER_KEY = "_user";
     private Long id;
     private String username;
     private String passWord;
     private String fullName;
     private String mobile;

     
}
