package com.fux.afk.auth.service.impl;

import com.fux.afk.auth.entity.SysUser;
import com.fux.afk.auth.entity.SysUserRole;
import com.fux.afk.auth.repository.UserRepository;
import com.fux.afk.auth.repository.UserRoleRepository;
import com.fux.afk.auth.service.UserService;
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

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

/**
 * Created by fuxj on 2019/3/6
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public SysUser getUser(String username) {
        return userRepository.getUserByName(username);
    }

    @Override
    public BootstrapTable list(SearchVo search) {
        SysUser user = new SysUser();
        user.setName(MapUtils.getString(search.getArgs(), "name"));
        user.setRealName(MapUtils.getString(search.getArgs(), "realName"));
        user.setPhone(MapUtils.getString(search.getArgs(), "phone"));
        Example<SysUser> example = Example.of(user);
        Pageable pageable = PageRequest.of(search.getPage() - 1, search.getRows());
        Page<SysUser> page = userRepository.findAll(example, pageable);
        return new BootstrapTable(page);
    }

    @Override
    public ResultVo saveOrUpdate(SysUser user, BigDecimal roleId) {
        try {
            //判断用户名是否存在
            SysUser existsUser = userRepository.getUserByName(user.getName());
            if(StringUtils.isEmpty(user.getId())) {
                if(null != existsUser) {
                    return ResultVo.failedInfo("用户名已存在,请重新输入...");
                }
                user.setCreateTime(new Date());
                user.setPassword("123456");
                user.setIsEnabled("Y");
                userRepository.save(user);
                SysUserRole userRole = new SysUserRole();
                userRole.setRoleId(roleId);
                userRole.setUserId(user.getId());
                userRoleRepository.save(userRole);
            } else {
                if(null != existsUser && !existsUser.getId().equals(user.getId())) {
                    return ResultVo.failedInfo("用户名已存在,请重新输入...");
                }
                SysUser oldUser = userRepository.getOne(user.getId());
                if(null != oldUser) {
                    oldUser.setName(user.getName());
                    oldUser.setRealName(user.getRealName());
                    oldUser.setPhone(user.getPhone());
                    oldUser.setUpdateTime(new Date());
                    userRepository.save(oldUser);
                    //修改角色权限
                    SysUserRole userRole = new SysUserRole();
                    userRole.setUserId(oldUser.getId());
                    userRole.setRoleId(roleId);
                    Example<SysUserRole> example = Example.of(userRole);
                    Optional<SysUserRole> optional = userRoleRepository.findOne(example);
                    if(!optional.isPresent()) {
                        userRoleRepository.save(userRole);
                    }
                }
            }
            return ResultVo.successInfo("操作成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.failedInfo("操作过程中出现异常!" );
        }
    }

    @Override
    public SysUser getUserById(BigDecimal id) {
        return userRepository.getOne(id);
    }

    @Override
    public ResultVo delete(BigDecimal id) {
        try {
            userRepository.deleteById(id);
            return ResultVo.successInfo("删除成功！");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return ResultVo.failedInfo("操作过程中出现异常!" );
        }
    }
}
