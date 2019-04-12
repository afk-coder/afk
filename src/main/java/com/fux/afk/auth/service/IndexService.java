package com.fux.afk.auth.service;

import com.fux.afk.auth.entity.Permission;

import java.util.List;
import java.util.Map;

/**
 * Created by fuxj on 2019/3/13
 */
public interface IndexService {

    List<Permission> findPermissionByUserId(Integer userId);
}
