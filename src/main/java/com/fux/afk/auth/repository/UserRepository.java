package com.fux.afk.auth.repository;

import com.fux.afk.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by fuxj on 2019-4-2
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from sys_user where name = ?", nativeQuery = true)
    User getUserByName(String name);

}
