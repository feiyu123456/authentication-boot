package com.example.repository;

import com.example.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Integer>{

    Optional<UserEntity> findByUserName(String userName);

    @Query(value = "select d.code from tb_user a \n" +
            "left join tb_user_role b on a.id = b.user_id\n" +
            "left join tb_role_permission c on c.role_id = b.role_id\n" +
            "left join tb_permission d on d.id = c.permission_id\n" +
            "where a.id = ?1", nativeQuery = true)
    List<String> queryPermissionsByUserId(Integer userId);
}
