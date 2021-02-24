package org.lanqiao.controller;

import org.lanqiao.entity.Admin;
import org.lanqiao.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class AdminController {
    @Resource
    AdminService adminService;
    @RequestMapping("/admin/login.do")
    public String login(Admin admin, HttpSession session, Model model) {
        Admin admin1 = adminService.checkUser(admin);
        if(admin1 == null){
            model.addAttribute("errorMsg","对不起，用户名或密码错误");
            return "/view/login";
        }else {
            session.setAttribute("admin", admin1);
            return "/index";
        }
    }

    @RequestMapping("/admin/updatePwd.do")
    public String updatePwd(Admin admin, HttpSession session, HttpServletRequest request){
        String old_pwd = request.getParameter("old_pwd");
        String apwd1 = request.getParameter("apwd");
        String apwd2 = request.getParameter("apwd2");
        Admin admin2 = (Admin) session.getAttribute("admin");
        if (!admin2.getApwd().equals(old_pwd)) {
            request.setAttribute("errorMsg", "对不起，旧密码不正确");
            return "/login";
        }
        boolean c = (apwd1.equals(apwd2));
        if (c) {
            admin2.setApwd(apwd1);
            boolean b = adminService.updateAdminPwd(admin2);
            if (b)
                session.invalidate();
            return "/login";
        } else {
            request.setAttribute("errorMsg", "密码修改失败");
            return "/user/user_modi_pwd";
        }
    }
    @RequestMapping("/admin/updateInfo.do")
    public void updateInfo(Admin admin, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String aname = request.getParameter("aname");
        String atel = request.getParameter("atel");
        String aemail = request.getParameter("aemail");
        String id = request.getParameter("id");
        Admin admin3 = new Admin(Integer.parseInt(id), aname, atel, aemail);
        boolean b = adminService.updateAdminInfo(admin3);
        admin3.setAname(aname);
        admin3.setAtel(atel);
        admin3.setAemail(aemail);
        if(b) {
            request.getSession().setAttribute("admin", admin3);
            response.getWriter().println("更新成功");
        }else {
            response.getWriter().println("更新失败");
        }
    }
}
