package com.example.entity;

import com.example.dto.UserDto;
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

    @Column(name = "name", nullable = false, unique = false)
    private String name;

    @Column(name = "pass_word", nullable = false,length = 255)
    private String passWord;

    @ManyToMany
    @JoinTable(name = "tb_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {
            @JoinColumn(name = "id")}, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT), inverseForeignKey =
    @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<RoleEntity> roles;

    public UserDto userEntityMapUserDto() {
        return new UserDto(id, this.name, this.passWord,name, null);
    }

}
