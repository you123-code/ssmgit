package org.lanqiao.controller;

import com.github.pagehelper.PageInfo;
import org.lanqiao.entity.Priv;
import org.lanqiao.entity.Role;
import org.lanqiao.service.PrivService;
import org.lanqiao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RoleController {
    @Autowired
    RoleService roleService;
    @Autowired
    PrivService privService;
    @RequestMapping("/role/roleListAction.do")
    public String showRolelist(@RequestParam(name="pageNum",required = false,defaultValue = "1") int pageNum, Model model) {
        PageInfo<Role> list = roleService.getAllRoles2(pageNum);
        model.addAttribute("pageInfo", list);
        return "role/role_list";
    }
    @RequestMapping("/role/showAddRole.do")
    public String showAddRoleAction(HttpServletRequest request,HttpSession session){
        List<Priv> lp =  privService.getAllPrivs();
        request.setAttribute("lp", lp);
        System.out.println(lp);
        return "/role/role_add";
    }
    @RequestMapping("/role/roleAdd.do")
    public String roleAddAction(HttpSession session, HttpServletRequest request, @RequestParam("by001") MultipartFile file ) throws ServletException, IOException {
        String rname = request.getParameter("rname");
        String[] privs =  request.getParameterValues("privs");
        //保存页面路径，图片上传成功后，将路径保存到数据库
        String filePath = request.getServletContext().getRealPath("/upload");
        //获取原始图片的扩展名
        String originalFileName = file.getOriginalFilename();
        //获取原始图片的扩展名
        String originalFilename = file.getOriginalFilename();
        //生成文件新的名字
        String newFileName = originalFilename;
        //封装上传文件位置的全路径
        File targetFile = new File(filePath,newFileName);
        file.transferTo(targetFile);

        Role role = new Role();
        role.setRname(rname);//页面传来的rname角色名字
        role.setBy001("/upload/"+newFileName);
        List<Priv> lp = new ArrayList<>();
        for(String pid : privs) {
            lp.add(new Priv(Integer.parseInt(pid)));
        }
        role.setLp(lp);
        boolean b = roleService.insertRole(role);
        if(b) {
            //添加成功
            request.setAttribute("state", "1");
        }else {
            //添加失败
            request.setAttribute("state", "0");
        }
        return "redirect:/role/showAddRole.do";
    }
    @RequestMapping ("/role/roleDel.do")
    public String roleDelAction(HttpServletRequest request){
        String rid = request.getParameter("rid");
        System.out.println("RoleDelAction" + rid);
        boolean b = roleService .deleteRole(Integer.parseInt(rid));
        if (b) {
            request.setAttribute("state", "1");
        } else {
            request.setAttribute("state", "0");
        }
        return ("redirect:/role/roleListAction.do");
    }
}

