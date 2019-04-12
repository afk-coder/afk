package com.fux.afk.auth.service;

import com.fux.afk.auth.entity.User;
import com.fux.afk.support.vo.BootstrapTable;
import com.fux.afk.support.vo.ResultVo;
import com.fux.afk.support.vo.SearchVo;

/**
 * Created by fuxj on 2019/3/6
 */
public interface UserService {

    User getUser(String username);

    BootstrapTable list(SearchVo search);

    ResultVo saveOrUpdate(User user, Integer roleId);

    User getUserById(Integer id);

    ResultVo delete(String id);
}
