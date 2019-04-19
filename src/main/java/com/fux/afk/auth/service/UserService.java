package com.fux.afk.auth.service;

import com.fux.afk.auth.entity.SysUser;
import com.fux.afk.support.vo.BootstrapTable;
import com.fux.afk.support.vo.ResultVo;
import com.fux.afk.support.vo.SearchVo;

import java.math.BigDecimal;

/**
 * Created by fuxj on 2019/3/6
 */
public interface UserService {

    SysUser getUser(String username);

    BootstrapTable list(SearchVo search);

    ResultVo saveOrUpdate(SysUser user, BigDecimal roleId);

    SysUser getUserById(BigDecimal id);

    ResultVo delete(BigDecimal id);
}
