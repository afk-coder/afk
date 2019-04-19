package com.fux.afk.auth.controller;

import com.fux.afk.auth.entity.SysRole;
import com.fux.afk.auth.entity.SysUser;
import com.fux.afk.auth.service.RoleService;
import com.fux.afk.auth.service.UserService;
import com.fux.afk.support.vo.BootstrapTable;
import com.fux.afk.support.vo.ResultVo;
import com.fux.afk.support.vo.SearchVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by fuxj on 2019-3-21
 */
@Controller
@RequestMapping("/auth/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
//    @RequiresPermissions("user:list")
    public String listView() {
        return "/auth/user/list";
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
//    @RequiresPermissions("user:list")
    public BootstrapTable list(SearchVo search) {
        return userService.list(search);
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
//    @RequiresPermissions("user:add")
    public String addView(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        if(!StringUtils.isEmpty(id)) {
            SysUser user = userService.getUserById(new BigDecimal(id));
            model.addAttribute("user", user);
            List<SysRole> existsRole = roleService.getListByUserId(new BigDecimal(id));
            model.addAttribute("existsRole", existsRole.get(0));
        }
        List<SysRole> listRole = roleService.findAll();
        model.addAttribute("listRole", listRole);
        return "/auth/user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
//    @RequiresPermissions("user:add")
    public ResultVo add(SysUser user, BigDecimal roleId) {
        return userService.saveOrUpdate(user, roleId);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("user:delete")
    public ResultVo delete(BigDecimal id) {
        return userService.delete(id);
    }
}
