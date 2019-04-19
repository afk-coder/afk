package com.fux.afk.auth.repository;

import com.fux.afk.auth.entity.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by fuxj on 2019-4-2
 */
public interface PermissionRepository extends JpaRepository<SysPermission, BigDecimal> {

    @Query(value = "select p.* from sys_role_permission rp, sys_permission p where rp.permission_id = p.id and rp.role_id = ? ", nativeQuery = true)
    List<SysPermission> findAllByRoleId(BigDecimal roleId);

    @Query(value = "select * from sys_permission where parent_id = ?", nativeQuery = true)
    List<SysPermission> findAllByParentId(BigDecimal parentId);

    @Query(value = "select p.* from sys_role_permission rp, sys_permission p,sys_user_role sur where rp.permission_id = p.id and sur.role_id = rp.role_id and sur.user_id = ? order by p.sorting asc", nativeQuery = true)
    List<SysPermission> findAllByUserId(BigDecimal userId);

}
