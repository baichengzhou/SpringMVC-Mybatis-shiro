package com.sojson.user.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sojson.common.dao.SOUserMapper;
import com.sojson.common.model.SOUser;
import com.sojson.user.service.SOUserService;
@Service("sOUserService")
public class SOUserServiceImpl implements SOUserService {

	@Autowired
	SOUserMapper userMapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public SOUser insert(SOUser record) {
		userMapper.insert(record);
		return record;
	}

	@Override
	public SOUser insertSelective(SOUser record) {
		userMapper.insertSelective(record);
		return record;
	}

	@Override
	public SOUser selectByPrimaryKey(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(SOUser record) {
		return userMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(SOUser record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public SOUser findLogin(String email, String password) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("password", password);
		return userMapper.findLogin(map);
	}
	
	

}
