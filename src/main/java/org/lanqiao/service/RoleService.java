package org.lanqiao.service;

import com.github.pagehelper.PageInfo;
import org.lanqiao.entity.Role;

import java.util.List;



public interface RoleService {
/**
 * 获取所有角色信息
 * @return
 */
	List<Role> getAllRoles();

    /**
     * 获取所有分页信息
     * @param pageNum 当前第几页
     * @return
     */
    PageInfo<Role> getAllRoles2(int pageNum);
	/**
	 * 添加角色信息
	 * @param role
	 * @return
	 */
    boolean insertRole(Role role);
    /**
     *删除角色
     * @param rid
     * @return
     */
    boolean deleteRole(Integer rid);
    /**
     * 通过角色id获取角色所有信息（包括权限）
     * @param rid
     * @return
     */
    Role  getRoleByRid(Integer rid);
    /**
     * 修改角色信息
     * @param role
     * @return
     */
    boolean updateRole(Role role);
    List<Role> selectRoleByAid(String aid);
}
