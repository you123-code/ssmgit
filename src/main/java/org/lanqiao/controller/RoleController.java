package org.lanqiao.controller;

import com.github.pagehelper.PageInfo;
import org.lanqiao.entity.Role;
import org.lanqiao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class RoleController {
    @Autowired
    RoleService roleService;
    @RequestMapping("role/roleListAction.do")
    public String showRolelist(@RequestParam(name="pageNum",required = false,defaultValue = "1") int pageNum, Model model) {
        PageInfo<Role> list = roleService.getAllRoles2(pageNum);
        model.addAttribute("pageInfo", list);
        return "role/role_list";
    }
}

