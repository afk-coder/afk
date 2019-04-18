package com.fux.afk.auth.service.impl;


import com.fux.afk.auth.entity.SysPermission;
import com.fux.afk.auth.repository.PermissionRepository;
import com.fux.afk.auth.service.PermissionService;
import com.fux.afk.support.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fuxj on 2019/3/7
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<SysPermission> getListByRoleId(Integer roleId) {
        return permissionRepository.findAllByRoleId(roleId);
    }

    @Override
    public List<SysPermission> list() {
        return permissionRepository.findAll();
    }

    @Override
    public SysPermission getPermissionById(Integer id) {
        return permissionRepository.getOne(id);
    }

    @Override
    public ResultVo saveOrUpdate(SysPermission permission) {
        try {
            permissionRepository.save(permission);
            return ResultVo.successInfo("保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.failedInfo("保存过程中出现异常！");
        }

    }

    @Override
    public ResultVo delete(Integer id) {
        try {
            permissionRepository.deleteById(id);
            return ResultVo.successInfo("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.failedInfo("删除过程中出现异常!");
        }
    }
}
