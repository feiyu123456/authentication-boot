package com.example.repository;

import com.example.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleEntityRepository extends JpaRepository<RoleEntity, Long> {

    List<RoleEntity> findRoleEntitiesByUserId(Long userId);
}
