package com.fux.afk.auth.service;

import com.fux.afk.auth.entity.Permission;
import com.fux.afk.support.vo.ResultVo;

import java.util.List;

/**
 * Created by fuxj on 2019/3/7
 */
public interface PermissionService {

    List<Permission> getListByRoleId(Integer roleId);

    List<Permission> list();

    Permission getPermissionById(Integer id);

    ResultVo saveOrUpdate(Permission permission);

    ResultVo delete(Integer id);
}
