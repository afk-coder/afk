package com.fux.afk.auth.controller;

import com.fux.afk.auth.entity.SysPermission;
import com.fux.afk.auth.service.PermissionService;
import com.fux.afk.support.vo.ResultVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by fuxj on 2019/3/14
 */
@Controller
@RequestMapping("/auth/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @RequiresPermissions("permission:list")
    public String listView() {
        return "/auth/permission/list";
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("permission:list")
    public List<SysPermission> list() {
        return permissionService.list();
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    @RequiresPermissions("permission:add")
    public String addView(HttpServletRequest request, Model model) {
        String parentId = request.getParameter("parentId");
        if (!"0".equals(parentId)) {
            SysPermission permission = permissionService.getPermissionById(new BigDecimal(parentId));
            model.addAttribute("permission", permission);
        }
        return "/auth/permission/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("permission:add")
    public ResultVo add(SysPermission permission) {
        return permissionService.saveOrUpdate(permission);
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    @RequiresPermissions("permission:update")
    public String updateView(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        SysPermission permission = permissionService.getPermissionById(new BigDecimal(id));
        model.addAttribute("permission", permission);
        return "/auth/permission/update";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("permission:update")
    public ResultVo update(SysPermission permission) {
        return permissionService.saveOrUpdate(permission);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("permission:delete")
    public ResultVo delete(BigDecimal id) {
        return permissionService.delete(id);
    }

}
