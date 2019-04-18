package com.fux.afk.auth.service;

import com.fux.afk.auth.entity.SysPermission;
import com.fux.afk.support.vo.ResultVo;

import java.util.List;

/**
 * Created by fuxj on 2019/3/7
 */
public interface PermissionService {

    List<SysPermission> getListByRoleId(Integer roleId);

    List<SysPermission> list();

    SysPermission getPermissionById(Integer id);

    ResultVo saveOrUpdate(SysPermission permission);

    ResultVo delete(Integer id);
}
