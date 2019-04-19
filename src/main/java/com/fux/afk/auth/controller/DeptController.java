package com.fux.afk.auth.controller;

import com.fux.afk.auth.entity.SysDept;
import com.fux.afk.auth.service.DeptService;
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
 * Created by fuxj on 2019-4-19
 */
@Controller
@RequestMapping("/auth/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @RequiresPermissions("dept:list")
    public String listView() {
        return "/auth/dept/list";
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("dept:list")
    public List<SysDept> list() {
        return deptService.list();
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    @RequiresPermissions("dept:add")
    public String addView(HttpServletRequest request, Model model) {
        String parentId = request.getParameter("parentId");
        if (!"0".equals(parentId)) {
            SysDept dept = deptService.getDeptById(new BigDecimal(parentId));
            model.addAttribute("dept", dept);
        }
        return "/auth/dept/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("dept:add")
    public ResultVo add(SysDept dept) {
        return deptService.saveOrUpdate(dept);
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    @RequiresPermissions("dept:update")
    public String updateView(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        SysDept dept = deptService.getDeptById(new BigDecimal(id));
        model.addAttribute("dept", dept);
        return "/auth/dept/update";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("dept:update")
    public ResultVo update(SysDept dept) {
        return deptService.saveOrUpdate(dept);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("dept:delete")
    public ResultVo delete(BigDecimal id) {
        return deptService.delete(id);
    }
}
