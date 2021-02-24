package org.lanqiao.service.impl;


import org.lanqiao.entity.Admin;
import org.lanqiao.mapper.AdminMapper;
import org.lanqiao.mapper.PrivMapper;
import org.lanqiao.mapper.RoleMapper;
import org.lanqiao.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
