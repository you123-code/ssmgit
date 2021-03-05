package org.lanqiao.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.entity.Admin;
import org.lanqiao.mapper.AdminMapper;
import org.lanqiao.mapper.PrivMapper;
import org.lanqiao.mapper.RoleMapper;
import org.lanqiao.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
    AdminMapper adminMapper;
	@Autowired
    PrivMapper privMapper;
    @Autowired
    RoleMapper roleMapper;

	public Admin checkUser(Admin admin2) {
		//校验用户和密码
		Admin admin = adminMapper.selectAdminByAcnameAndApwd(admin2);
		// 登录成功
		if(admin != null) {
			//第二步，获取该用户对应的所有权限
			admin.setLp(privMapper.selectPrivsByAid(admin.getId()));
			//第三步，获取该用户对应的所有角色
			admin.setLr(roleMapper.selectRolesByAid(admin.getId()));
		}
		return admin;	
	}


	public boolean updateAdminPwd(Admin admin) {

		return adminMapper.updateAdminPwd(admin) > 0;
	}

	public boolean updateAdminInfo(Admin admin) {

		return adminMapper.updateAdminInfo(admin)>0;
	}

	public PageInfo<Admin> selectAllAdmin(int pageNum) {
		PageHelper.startPage(pageNum,2);
		List<Admin> list = adminMapper.selectAllAdmins();
		PageInfo<Admin> pageInfo = new PageInfo<Admin>(list);
		return pageInfo;
	}

	public boolean insertAdmin(Admin admin) {
		int i = adminMapper.insertAdmin(admin);
		//通过admin 找到rid
		Admin admin1 = adminMapper.selectAdminbyaname(admin.getAname());
		admin.setId(admin1.getId());
		int j = adminMapper.insertAdminRole(admin);
		return i>0&&j>0;
	}

	public boolean delAdmin(String id) {
		int i = adminMapper.delAdmin(Integer.parseInt(id));
		int j = adminMapper.delAdminRole(Integer.parseInt(id));
		return i>0&&j>0;
	}

	public Admin getAdminByid(int id) {
		//Admin admins = adminMapper.selectAdminByid(id);
		return adminMapper.selectAdminByid(id);
		//return admins;
	}

	public boolean updateAdmin(Admin admin) {
		int r = adminMapper.updateAdmin(admin);
		int dr = adminMapper.delAdminRole(admin.getId());
		int ir = adminMapper.insertAdminRole(admin);
		return r > 0 && dr>0 && ir>0;
	}

}
