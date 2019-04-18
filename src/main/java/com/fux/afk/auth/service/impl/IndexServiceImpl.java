package com.fux.afk.auth.service.impl;

import com.fux.afk.auth.entity.SysPermission;
import com.fux.afk.auth.repository.PermissionRepository;
import com.fux.afk.auth.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fuxj on 2019/3/13
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private PermissionRepository permissoinRepository;

    @Override
    public List<SysPermission> findPermissionByUserId(Integer userId) {
        return permissoinRepository.findAllByUserId(userId);
    }
}
