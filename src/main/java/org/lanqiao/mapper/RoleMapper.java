package org.lanqiao.mapper;

import org.apache.ibatis.annotations.Select;
import org.lanqiao.entity.Role;

import java.util.List;



public interface RoleMapper {
	List<Role> selectRolesByAid(Integer aid);
	/**
	 * 获取所有角色
	 * @return
	 */
	@Select("select * from tc_role")
    List<Role> selectAllRoles();
    /**
     * 根据角色名称rname查询
     * @param rname
     * @return
     */
    Role selectRoleByRname(String rname);
    /**
     * 添加角色
     * @param role
     * @return
     */
    int insertRole(Role role);
    /**
     * 添加角色-权限关联表
     * @param role
     * @return
     */
    int insertRolePriv(Role role);
    /**
     * 根据rid查询是否有对应的关联用户
     * @param rid
     * @return boolean true - 表示有关联
     */
    boolean selectAdminsByRid(Integer rid);
    /**
     * 删除角色权限关联表 生哥是没有s
     * @param rid
     * @return
     */
    int deleteRolePrivsByRid(Integer rid);
    /**
     * 删除角色表
     * @param rid
     * @return
     */
    int deleteRoleByRid(Integer rid);
    /**
     * 通过rid查询角色
     * @param rid
     * @return
     */
     Role selectRoleByRid(Integer rid);
    /**
     * 修改role
     * @param role
     * @return
     */
    int updateRole(Role role);
}
