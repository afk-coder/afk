package com.fux.afk.auth.service.impl;

import com.fux.afk.auth.entity.RolePermission;
import com.fux.afk.auth.entity.User;
import com.fux.afk.auth.entity.UserRole;
import com.fux.afk.auth.repository.UserRepository;
import com.fux.afk.auth.repository.UserRoleRepository;
import com.fux.afk.auth.service.UserService;
import com.fux.afk.support.vo.BootstrapTable;
import com.fux.afk.support.vo.ResultVo;
import com.fux.afk.support.vo.SearchVo;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    public User getUser(String username) {
        return userRepository.getUserByName(username);
    }

    @Override
    public BootstrapTable list(SearchVo search) {
        User user = new User();
        user.setName(MapUtils.getString(search.getArgs(), "name"));
        user.setRealName(MapUtils.getString(search.getArgs(), "realName"));
        user.setPhone(MapUtils.getString(search.getArgs(), "phone"));
        Example<User> example = Example.of(user);
        Pageable pageable = PageRequest.of(search.getPage() - 1, search.getRows());
        Page<User> page = userRepository.findAll(example, pageable);
        return new BootstrapTable(page);
    }

    @Override
    public ResultVo saveOrUpdate(User user, Integer roleId) {
        try {
            //判断用户名是否存在
            User existsUser = userRepository.getUserByName(user.getName());
            if(StringUtils.isEmpty(user.getId())) {
                if(null != existsUser) {
                    return ResultVo.failedInfo("用户名已存在,请重新输入...");
                }
                user.setCreateTime(new Date());
                user.setPassword("123456");
                user.setIsEnabled("Y");
                userRepository.save(user);
                UserRole userRole = new UserRole();
                userRole.setRoleId(roleId);
                userRole.setUserId(user.getId());
                userRoleRepository.save(userRole);
            } else {
                if(null != existsUser && !existsUser.getId().equals(user.getId())) {
                    return ResultVo.failedInfo("用户名已存在,请重新输入...");
                }
                User oldUser = userRepository.getOne(user.getId());
                if(null != oldUser) {
                    oldUser.setName(user.getName());
                    oldUser.setRealName(user.getRealName());
                    oldUser.setPhone(user.getPhone());
                    oldUser.setUpdateTime(new Date());
                    userRepository.save(oldUser);
                    //修改角色权限
                    UserRole userRole = new UserRole();
                    userRole.setUserId(oldUser.getId());
                    userRole.setRoleId(roleId);
                    Example<UserRole> example = Example.of(userRole);
                    Optional<UserRole> optional = userRoleRepository.findOne(example);
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
    public User getUserById(Integer id) {
        return userRepository.getOne(id);
    }

    @Override
    public ResultVo delete(String id) {
        try {
            userRepository.deleteById(Integer.valueOf(id));
            return ResultVo.successInfo("删除成功！");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return ResultVo.failedInfo("操作过程中出现异常!" );
        }
    }
}