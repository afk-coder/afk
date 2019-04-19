package com.fux.afk.auth.service;

import com.fux.afk.auth.entity.SysPermission;
import com.fux.afk.support.vo.ResultVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by fuxj on 2019/3/7
 */
public interface PermissionService {

    List<SysPermission> getListByRoleId(BigDecimal roleId);

    List<SysPermission> list();

    SysPermission getPermissionById(BigDecimal id);

    ResultVo saveOrUpdate(SysPermission permission);

    ResultVo delete(BigDecimal id);
}
