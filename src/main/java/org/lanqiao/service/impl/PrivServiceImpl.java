package org.lanqiao.service.impl;

import org.lanqiao.entity.Priv;
import org.lanqiao.mapper.PrivMapper;
import org.lanqiao.service.PrivService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("PrivService")
public class PrivServiceImpl implements PrivService {
	@Autowired
	PrivMapper privMapper;
	public List<Priv> getAllPrivs() {
		// TODO Auto-generated method stub
		return  privMapper.selectAllPrivs();
	}

}
