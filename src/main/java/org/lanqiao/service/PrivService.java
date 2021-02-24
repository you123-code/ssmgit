package org.lanqiao.service;

import org.lanqiao.entity.Priv;

import java.util.List;



public interface PrivService {
/**
 *获取所有权限
 * @return
 */
	List<Priv> getAllPrivs();
}
