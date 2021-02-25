package org.lanqiao.controller;

import com.github.pagehelper.PageInfo;
import org.lanqiao.entity.Priv;
import org.lanqiao.entity.Role;
import org.lanqiao.service.RoleService;
import org.lanqiao.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
    @RequestMapping("role/showAddRole.do")
    public String roleAddAction(Role role, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rname = request.getParameter("rname");
        String[] privs =  request.getParameterValues("privs");
        Part img = request.getPart("by001");
        String fname = img.getSubmittedFileName();
        InputStream is = img.getInputStream();
        FileOutputStream fos = new FileOutputStream(request.getRealPath("/upload")+"/"+fname);
        int i = -1;
        while((i = is.read()) != -1){
            fos.write(i);
        }
        is.close();
        fos.close();

        Role role1 = new Role();
        role.setRname(rname);
        //存放图片地址
        role1.setBy001("/upload/"+fname);//http://localhost/upload/abc.png

        List<Priv> lp = new ArrayList<>();
        for(String pid : privs) {
            lp.add(new Priv(Integer.parseInt(pid)));
        }
        role.setLp(lp);
        boolean b = new RoleServiceImpl().insertRole(role);
        if(b) {
            //添加成功
            request.setAttribute("state", "1");
        }else {
            //添加失败
            request.setAttribute("state", "0");
        }
        return "role/role.list.jsp";
    }
}

