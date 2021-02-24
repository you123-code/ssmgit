package org.lanqiao.service;

import org.lanqiao.entity.Admin;

public interface AdminService {
	/**
	 * 登录功能
	 * @param admin
	 * @return
	 */
	Admin checkUser(Admin admin);

	/**
	 * 修改密码
	 * @param admin
	 * @return
	 */
	boolean updateAdminPwd(Admin admin);
	/**
	 * 修改个人信息
	 * @param admin
	 * @return
	 */
	boolean updateAdminInfo(Admin admin);
}
