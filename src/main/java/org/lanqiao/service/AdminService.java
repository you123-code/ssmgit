package org.lanqiao.service;

import com.github.pagehelper.PageInfo;
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
	/**
	 * 查询所有管理员信息
	 * @return
	 */
	PageInfo<Admin> selectAllAdmin(int pageNum);
	/**
	 * 增加管理员
	 * @param admin
	 * @return
	 */
	boolean insertAdmin(Admin admin);

	/**
	 * 删除管理员
	 * @param id
	 * @return
	 */
	boolean delAdmin(String id);

	/**
	 * 修改管理员信息
	 * @param parseInt
	 * @return
	 */
	Admin getAdminByid(int parseInt);

	/**
	 * 修改管理员信息
	 * @param admin
	 * @return
	 */
	boolean updateAdmin(Admin admin);
}
