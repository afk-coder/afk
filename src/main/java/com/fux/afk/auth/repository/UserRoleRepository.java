package com.fux.afk.auth.repository;

import com.fux.afk.auth.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fuxj on 2019-4-12
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
}