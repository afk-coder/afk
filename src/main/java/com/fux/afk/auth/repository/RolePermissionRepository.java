package com.fux.afk.auth.repository;

import com.fux.afk.auth.entity.SysRolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fuxj on 2019-4-4
 */
public interface RolePermissionRepository extends JpaRepository<SysRolePermission, Integer> {



}
