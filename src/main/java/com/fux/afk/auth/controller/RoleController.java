package com.fux.afk.auth.controller;

import com.fux.afk.auth.entity.Permission;
import com.fux.afk.auth.entity.Role;
import com.fux.afk.auth.entity.User;
import com.fux.afk.auth.service.PermissionService;
import com.fux.afk.auth.service.RoleService;
import com.fux.afk.support.vo.BootstrapTable;
import com.fux.afk.support.vo.ResultVo;
import com.fux.afk.support.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fuxj on 2019-3-21
 */
@Controller
@RequestMapping("/auth/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String listView() {
        return "/auth/role/list";
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public BootstrapTable list(SearchVo search) {
        return roleService.list(search);
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addView(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        if(!StringUtils.isEmpty(id)) {
            Role role = roleService.getRoleById(Integer.valueOf(id));
            model.addAttribute("role", role);
        }
        return "/auth/role/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo add(Role role) {
        return roleService.saveOrUpdate(role);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo delete(HttpServletRequest request) {
        String id = request.getParameter("id");
        return roleService.delete(id);
    }

    @RequestMapping(value = "grant", method = RequestMethod.GET)
    public String grantView(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        Role role = roleService.getRoleById(Integer.valueOf(id));
        List<Permission> list = permissionService.getListByRoleId(role.getId());
        List<Integer> checkIds = new ArrayList<>();
        for (Permission permission : list) {
            checkIds.add(permission.getId());
        }
        model.addAttribute("role", role);
        model.addAttribute("checkIds", checkIds);
        return "/auth/role/grant";
    }

    @RequestMapping(value = "listCheck", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> listCheck(HttpServletRequest request) {
        String id = request.getParameter("id");
        List<Map<String, Object>> result = new ArrayList<>();
        List<Permission> list = permissionService.list();
        for (Permission permission : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", permission.getId());
            map.put("parentId", permission.getParentId());
            map.put("name", permission.getName());
            List<Permission> listCheck = permissionService.getListByRoleId(Integer.valueOf(id));
            for (Permission permission1 : listCheck) {
                if(permission.getId().equals(permission1.getId())) {
                    map.put("checked", true);
                }
            }
            result.add(map);
        }
        return result;
    }

    @RequestMapping(value = "grant", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo grant(HttpServletRequest request) {
        String roleId = request.getParameter("roleId");
        String ids = request.getParameter("ids");
        String idsUncheck = request.getParameter("ids_uncheck");
        return roleService.saveGrant(roleId, ids, idsUncheck);
    }
}
