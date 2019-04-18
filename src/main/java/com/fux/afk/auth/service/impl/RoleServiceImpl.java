package com.fux.afk.auth.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fux.afk.auth.entity.SysRole;
import com.fux.afk.auth.entity.SysRolePermission;
import com.fux.afk.auth.repository.RolePermissionRepository;
import com.fux.afk.auth.repository.RoleRepository;
import com.fux.afk.auth.service.RoleService;
import com.fux.afk.support.vo.BootstrapTable;
import com.fux.afk.support.vo.ResultVo;
import com.fux.afk.support.vo.SearchVo;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by fuxj on 2019/3/7
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Override
    public List<SysRole> getListByUserId(Integer userId) {
       return roleRepository.findAllByUserId(userId);
    }

    @Override
    public BootstrapTable list(SearchVo search) {
        SysRole role = new SysRole();
        role.setRoleName(MapUtils.getString(search.getArgs(), "roleName"));
        Example<SysRole> example = Example.of(role);
        Pageable pageable = PageRequest.of(search.getPage() - 1, search.getRows());
        Page<SysRole> page = roleRepository.findAll(example, pageable);
        return new BootstrapTable(page);
    }

    @Override
    public SysRole getRoleById(Integer id) {
        return roleRepository.getOne(id);
    }

    @Override
    public ResultVo saveOrUpdate(SysRole role) {
        try {
            //判断用户名是否存在
            SysRole existsRole = roleRepository.getRoleByRoleName(role.getRoleName());
            if(StringUtils.isEmpty(role.getId())) {
                if(null != existsRole) {
                    return ResultVo.failedInfo("角色已存在,请重新输入...");
                }
                roleRepository.save(role);
            } else {
                if(null != existsRole && !existsRole.getId().equals(role.getId())) {
                    return ResultVo.failedInfo("角色已存在,请重新输入...");
                }
                roleRepository.save(role);
            }
            return ResultVo.successInfo("操作成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.failedInfo("操作过程中出现异常!");
        }
    }

    @Override
    public ResultVo delete(String id) {
        try {
            roleRepository.deleteById(Integer.valueOf(id));
            return ResultVo.successInfo("删除成功！");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return ResultVo.failedInfo("操作过程中出现异常!" );
        }
    }

    @Override
    public ResultVo saveGrant(String roleId, String ids, String idsUncheck) {
        try {
            //角色权限
            List<SysRolePermission> rpList = new ArrayList<>();
            //删除权限
            List<SysRolePermission> rpunList = new ArrayList<>();
            //该角色勾选的权限
            ObjectMapper mapper = new ObjectMapper();
            List<Object> list = mapper.readValue(ids, new TypeReference<List<Object>>(){});
            for (Object o : list) {
                //获取该角色已存在的权限
                SysRolePermission rolePermission = new SysRolePermission();
                rolePermission.setRoleId(Integer.valueOf(roleId));
                rolePermission.setPermissionId(Integer.valueOf(o.toString()));
                Example<SysRolePermission> example = Example.of(rolePermission);
                Optional<SysRolePermission> existsRolePermission = rolePermissionRepository.findOne(example);
                //如果不存在,则需要新增
                if(!existsRolePermission.isPresent()) {
                    rpList.add(rolePermission);
                }
            }
            rolePermissionRepository.saveAll(rpList);
            //取消授权
            List<Object> listUncheck = mapper.readValue(idsUncheck, new TypeReference<List<Object>>(){});
            for (Object o : listUncheck) {
                SysRolePermission rolePermission = new SysRolePermission();
                rolePermission.setRoleId(Integer.valueOf(roleId));
                rolePermission.setPermissionId(Integer.valueOf(o.toString()));
                Example<SysRolePermission> example = Example.of(rolePermission);
                Optional<SysRolePermission> unRolePermission = rolePermissionRepository.findOne(example);
                //如果存在,则删除
                if(unRolePermission.isPresent()) {
                    rpunList.add(unRolePermission.get());
                }
            }
            rolePermissionRepository.deleteAll(rpunList);
            return ResultVo.successInfo("授权成功！");
        } catch (IOException e) {
            e.printStackTrace();
            return ResultVo.failedInfo("授权过程中出现异常!");
        }
    }

    @Override
    public List<SysRole> findAll() {
        return roleRepository.findAll();
    }
}
