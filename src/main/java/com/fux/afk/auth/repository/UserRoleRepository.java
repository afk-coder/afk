package com.fux.afk.auth.repository;

import com.fux.afk.auth.entity.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

/**
 * Created by fuxj on 2019-4-12
 */
public interface UserRoleRepository extends JpaRepository<SysUserRole, BigDecimal> {
}
