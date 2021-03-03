package org.lanqiao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.entity.Priv;
import org.lanqiao.entity.Role;
import org.lanqiao.mapper.PrivMapper;
import org.lanqiao.mapper.RoleMapper;
import org.lanqiao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleMapper roleDao ;
	@Autowired
    PrivMapper privDao ;
	@Override
	public List<Role> getAllRoles() {
		List<Role> list = roleDao.selectAllRoles();
		for(Role role : list) {
			List<Priv> lp = privDao.selectPrivByRid(role.getId());
			role.setLp(lp);
		}
		return list;
	}

	@Override
	public PageInfo<Role> getAllRoles2(int pageNum) {
		//把分页信息添加给pagehelper控件，以便拦截器使用,当前页码pageNum，每页多少条记录pageSize
		PageHelper.startPage(pageNum,3);
		List<Role> list = roleDao.selectAllRoles();
		for(Role role : list) {
			List<Priv> lp = privDao.selectPrivByRid(role.getId());
			role.setLp(lp);
		}
		//把查询结果封装到pageInfo
		PageInfo<Role> pageInfo = new PageInfo<Role>(list);
		return pageInfo;
	}

	public boolean insertRole(Role role) {
		//未用事务消除风险
		int i  = roleDao.insertRole(role);
		Role r = roleDao.selectRoleByRname(role);
		//把数据库中查询到的rid放入到role中，可以在关联表中关联
		role.setId(r.getId());
		int j = roleDao.insertRolePriv(role);
		return i > 0 && j > 0;
	}

	public boolean deleteRole(Integer rid) {
	    boolean b = roleDao.selectAdminsByRid(rid);
	  /* */
	    if(!b) {
	        int i =	roleDao.deleteRolePrivsByRid(rid);
	    	int j = roleDao.deleteRoleByRid(rid);
	    	return i > 0 && j >0;
	    }
		return false;
	}
	public Role getRoleByRid(Integer rid) {
		Role role = roleDao.selectRoleByRid(rid);
		List<Priv> lp = privDao.selectPrivByRid(rid);
		role.setLp(lp);//
		return role;
		
	}

	public boolean updateRole(Role role) {
		int i = roleDao.updateRole(role);
		int j = roleDao.deleteRolePrivsByRid(role.getId());
		int k = roleDao.insertRolePriv(role);
		return  i > 0 && j > 0 && k > 0 ;
	}
}
