package com.fux.afk.auth.repository;

import com.fux.afk.auth.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by fuxj on 2019-4-2
 */
public interface RoleRepository extends JpaRepository<SysRole, Integer> {

    @Query(value = "select r.* from sys_user_role ur, sys_role r where ur.role_id = r.id and ur.user_id = ?", nativeQuery = true)
    List<SysRole> findAllByUserId(Integer userId);

    @Query(value = "select * from sys_role where role_name = ?", nativeQuery = true)
    SysRole getRoleByRoleName(String roleName);
}
