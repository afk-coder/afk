package com.fux.afk.auth.repository;

import com.fux.afk.auth.entity.SysRolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

/**
 * Created by fuxj on 2019-4-4
 */
public interface RolePermissionRepository extends JpaRepository<SysRolePermission, BigDecimal> {

}
