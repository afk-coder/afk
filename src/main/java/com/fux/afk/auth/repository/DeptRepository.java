package com.fux.afk.auth.repository;

import com.fux.afk.auth.entity.SysDept;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

/**
 * Created by fuxj on 2019-4-19
 */
public interface DeptRepository extends JpaRepository<SysDept, BigDecimal> {
}
