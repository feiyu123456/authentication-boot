package com.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author jianping.yu@karakal.com.cn
 * @version 1.0
 * @date 2023/3/22
 **/
@Entity
@Table(name = "tb_role")
@Data
public class RoleEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "auth")
    private String auth;

    @Column(name = "user_id", nullable = false)
    private Long userId;
}
