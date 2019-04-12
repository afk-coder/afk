package com.fux.afk.auth.service.impl;


import com.fux.afk.auth.entity.Permission;
import com.fux.afk.auth.repository.PermissionRepository;
import com.fux.afk.auth.service.PermissionService;
import com.fux.afk.support.vo.JsTreeJson;
import com.fux.afk.support.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fuxj on 2019/3/7
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<Permission> getListByRoleId(Integer roleId) {
        return permissionRepository.findAllByRoleId(roleId);
    }

    @Override
    public List<Permission> list() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission getPermissionById(Integer id) {
        return permissionRepository.getOne(id);
    }

    @Override
    public ResultVo saveOrUpdate(Permission permission) {
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

    private List<JsTreeJson> findPermission(Integer parentId) {
        Permission params = new Permission();
        params.setParentId(parentId);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIncludeNullValues()
                .withMatcher("parentId", ExampleMatcher.GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.STARTING))
                .withIgnorePaths("id", "isButton", "isMenu", "name", "sorting", "url", "code");
        Example<Permission> example = Example.of(params, matcher);
        List<Permission> list  = permissionRepository.findAll(example);
        List<JsTreeJson> childres = new ArrayList<>();
        for (Permission permission : list) {
            JsTreeJson treeJson = new JsTreeJson();
            treeJson.setId(permission.getId().toString());
            treeJson.setText(permission.getName());
            treeJson.setChildren(findPermission(permission.getId()));
            childres.add(treeJson);
        }
        return childres;
    }
}