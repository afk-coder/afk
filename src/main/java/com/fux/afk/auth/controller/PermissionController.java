package com.fux.afk.auth.controller;

import com.fux.afk.auth.entity.Permission;
import com.fux.afk.auth.service.PermissionService;
import com.fux.afk.support.vo.JsTreeJson;
import com.fux.afk.support.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
    public String listView() {
        return "/auth/permission/list";
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public List<Permission> list() {
        return permissionService.list();
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addView(HttpServletRequest request, Model model) {
        String parentId = request.getParameter("parentId");
        if (!"0".equals(parentId)) {
            Permission permission = permissionService.getPermissionById(Integer.valueOf(parentId));
            model.addAttribute("permission", permission);
        }
        return "/auth/permission/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo add(Permission permission) {
        return permissionService.saveOrUpdate(permission);
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String updateView(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        Permission permission = permissionService.getPermissionById(Integer.valueOf(id));
        model.addAttribute("permission", permission);
        return "/auth/permission/update";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo update(Permission permission) {
        return permissionService.saveOrUpdate(permission);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo delete(Integer id) {
        return permissionService.delete(id);
    }

}
