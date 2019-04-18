package com.fux.afk.auth.service;

import com.fux.afk.auth.entity.SysRole;
import com.fux.afk.support.vo.BootstrapTable;
import com.fux.afk.support.vo.ResultVo;
import com.fux.afk.support.vo.SearchVo;

import java.util.List;

/**
 * Created by fuxj on 2019/3/7
 */
public interface RoleService {

    List<SysRole> getListByUserId(Integer userId);

    BootstrapTable list(SearchVo search);

    SysRole getRoleById(Integer id);

    ResultVo saveOrUpdate(SysRole user);

    ResultVo delete(String id);

    ResultVo saveGrant(String roleId, String ids, String idsUncheck);

    List<SysRole> findAll();
}
