package com.fux.afk.auth.repository;

import com.fux.afk.auth.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by fuxj on 2019-4-2
 */
public interface UserRepository extends JpaRepository<SysUser, Integer> {

    @Query(value = "select * from sys_user where name = ?", nativeQuery = true)
    SysUser getUserByName(String name);

}
