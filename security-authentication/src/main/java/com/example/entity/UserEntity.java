package com.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author jianping.yu@karakal.com.cn
 * @version 1.0
 * @date 2023/3/22
 **/
@Entity /**指定当前类是实体类， 对应数据库中一个表**/
@Table(name = "tb_user")
@Data
public class UserEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "pass_word", nullable = false)
    private String passWord;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "mobile")
    private String mobile;

    @ManyToMany
    @JoinTable(name = "tb_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {
            @JoinColumn(name = "id")}, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT), inverseForeignKey =
    @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<RoleEntity> roles;

}
