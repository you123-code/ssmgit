package org.lanqiao.mapper;


import org.lanqiao.entity.Admin;

import java.util.List;

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
	/**
	 * 查找所有管理员信息
	 */
	List<Admin> selectAllAdmins();

	/**
	 * 增加管理员
	 * @param admin
	 * @return
	 */
	int insertAdmin(Admin admin);

	/**
	 * 增加管理员角色
	 * @param admin
	 * @return
	 */
	int insertAdminRole(Admin admin);

	/**
	 * 通过管理员账号找管理员
	 * @param aname
	 * @return
	 */
	Admin selectAdminbyaname(String aname);

	/**
	 * 删除管理员
	 * @param id
	 * @return
	 */
	/*@Delete("delete from tc_admin where id=#{id}")*/
	int delAdmin(Integer id);

	/**
	 * 删除关联表
	 * @param id
	 * @return
	 */
	/*@Delete("delete from tc_admin_role where aid = #{id}")*/
	int delAdminRole(Integer id);

	/**
	 * 修改管理员
	 * @param admin
	 * @return
	 */
	//@Update("update tc_admin set aname=#{aname},acname=#{acname},atel=#{atel},aemail=#{aemail} where id=#{id}")
	int updateAdmin(Admin admin);
	/**
	 * 通过id查询的管理员
	 * @param id
	 * @return
	 */
	//@Select("select * from tc_admin where id=#{id}")
	Admin selectAdminByid(Integer id);
}
