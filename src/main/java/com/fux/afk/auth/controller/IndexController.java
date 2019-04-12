package com.fux.afk.auth.controller;

import com.fux.afk.auth.entity.Permission;
import com.fux.afk.auth.entity.User;
import com.fux.afk.auth.service.IndexService;
import com.fux.afk.auth.shiro.CustomRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by fuxj on 2019/3/7
 */
@Controller
public class IndexController {

    @Resource
    private IndexService indexService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        Subject subject = SecurityUtils.getSubject();
        //判断是否登录，未登录跳转登录页面
        if (!subject.isAuthenticated()) {
            return "redirect:/login";
        }
        User user = (User) subject.getSession().getAttribute(CustomRealm.SESSION_USER_KEY);
        List<Permission> list = indexService.findPermissionByUserId(user.getId());
        model.addAttribute("list", list);
        return "index";
    }

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home() {
        return "home";
    }
}
