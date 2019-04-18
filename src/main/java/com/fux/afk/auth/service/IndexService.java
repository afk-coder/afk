package com.fux.afk.auth.service;

import com.fux.afk.auth.entity.SysPermission;

import java.util.List;

/**
 * Created by fuxj on 2019/3/13
 */
public interface IndexService {

    List<SysPermission> findPermissionByUserId(Integer userId);
}
