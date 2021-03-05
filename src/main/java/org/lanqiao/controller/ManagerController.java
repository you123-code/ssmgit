package org.lanqiao.controller;

import com.github.pagehelper.PageInfo;
import org.lanqiao.entity.Admin;
import org.lanqiao.entity.Role;
import org.lanqiao.service.AdminService;
import org.lanqiao.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ManagerController {
    @Resource
    AdminService adminService;
    @Resource
    RoleService roleService;
    @RequestMapping("/admin/adminList.do")
    public String adminList(@RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,Model model){
        PageInfo<Admin> list = adminService.selectAllAdmin(pageNum);
        model.addAttribute("admins",list);
        return  "admin/admin_list";
    }
    @RequestMapping("/admin/showAdd.do")
    public String showAdd(Model model){
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("lr",roles);
        return "admin/admin_add";
    }
    @RequestMapping("/admin/adminAdd.do")
    public String adminAdd(@RequestParam String aname,@RequestParam String acname, @RequestParam String apwd, @RequestParam String rapwd, @RequestParam("aimg")MultipartFile file, @RequestParam String atel, @RequestParam String aemail, @RequestParam String[] roles,HttpServletRequest request,Model model) throws IOException {
        String fname = file.getOriginalFilename();
        InputStream is = file.getInputStream();
        FileOutputStream fos = new FileOutputStream(request.getServletContext().getRealPath("/aimg")+"/"+fname);
        int i = -1;
        while((i=is.read()) != -1) {
            fos.write(i);
        }
        is.close();
        fos.close();

        Admin admin = new Admin();
        if(apwd.equals(rapwd)){
            admin.setAname(aname);
            admin.setAcname(acname);
            admin.setApwd(apwd);
            admin.setAimg("/aimg"+fname);
            admin.setAtel(atel);
            admin.setAemail(aemail);

            List<Role> lr = new ArrayList<Role>();
            for (String id : roles) {
                lr.add(new Role(Integer.parseInt(id)));
            }
            admin.setLr(lr);
            boolean b = adminService.insertAdmin(admin);
        }
        return "redirect:/admin/showAdd.do";
    }
    @RequestMapping("/admin/adminDel.do")
    public String adminDel(@RequestParam String id ,Model model){
        boolean b = adminService.delAdmin(id);
        return "redirect:/admin/adminList.do";
    }
    @RequestMapping("/admin/adminUpdate.do")
    public String adminUpdate(@RequestParam String id, HttpServletRequest request, HttpServletResponse response, @RequestParam String aname, @RequestParam String acname, @RequestParam String atel, @RequestParam String aemail, @RequestParam String[] roles) throws IOException {
        Admin admin = new Admin();
        admin.setId(Integer.parseInt(id));
        admin.setAname(aname);
        admin.setAcname(acname);
        admin.setAtel(atel);
        admin.setAemail(aemail);

        List<Role> lr = new ArrayList<Role>();
        for (String ids : roles) {
            lr.add(new Role(Integer.parseInt(ids)));
        }
        admin.setLr(lr);
        boolean b = adminService.updateAdmin(admin);
        //return "redirect:/admin/adminShowUpdate.do";
        return "forward:/admin/adminList.do";
    }
    @RequestMapping("/admin/adminShowUpdate.do")
    public String adminShowUpdate(@RequestParam String id,Model model){
        List<Role> list = roleService.getAllRoles();
        Admin admin = adminService.getAdminByid(Integer.parseInt(id));
        admin.setLr(roleService.selectRoleByAid(id));
        model.addAttribute("list",list);
        model.addAttribute("admin2",admin);
        return "admin/admin_modi";
    }
}
