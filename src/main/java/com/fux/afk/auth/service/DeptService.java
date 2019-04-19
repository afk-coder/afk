package com.fux.afk.auth.service;

import com.fux.afk.auth.entity.SysDept;
import com.fux.afk.support.vo.ResultVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by fuxj on 2019-4-19
 */
public interface DeptService {

    List<SysDept> list();

    SysDept getDeptById(BigDecimal id);

    ResultVo delete(BigDecimal id);

    ResultVo saveOrUpdate(SysDept dept);
}
