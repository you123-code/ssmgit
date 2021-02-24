package org.lanqiao.mapper;


import org.lanqiao.entity.Admin;

public interface AdminMapper {
	/**
	 * 登录验证
	 * @param admin
	 * @return
	 */
	Admin selectAdminByAcnameAndApwd(Admin admin);
	/**
	 *修改密码
	 * @param admin
	 * @return
	 */
	int updateAdminPwd(Admin admin);
	/**
	 * 修改信息
	 * @param admin
	 * @return
	 */
	int updateAdminInfo(Admin admin);
}
