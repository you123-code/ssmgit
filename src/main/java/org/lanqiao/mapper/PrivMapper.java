package org.lanqiao.mapper;

import org.lanqiao.entity.Priv;

import java.util.List;


public interface PrivMapper {
/**
 * 通过aid获取权限
 * @param aid
 * @return
 */
	List<Priv> selectPrivsByAid(Integer aid);
	/**
	 * 通过角色id获取该角色的所以权限
	 */
	List<Priv> selectPrivByRid(Integer rid);
	/**
	 * 获取所有权限
	 * @return
	 */
	List<Priv> selectAllPrivs();
	
	
}
