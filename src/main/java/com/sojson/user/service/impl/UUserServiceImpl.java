package com.sojson.user.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sojson.common.dao.UUserMapper;
import com.sojson.common.model.UUser;
import com.sojson.core.mybatis.BaseMybatisDao;
import com.sojson.core.mybatis.page.Pagination;
import com.sojson.user.service.UUserService;

@Service
public class UUserServiceImpl extends BaseMybatisDao<UUserMapper> implements UUserService {

	@Resource
	UUserMapper userMapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public UUser insert(UUser entity) {
		userMapper.insert(entity);
		return entity;
	}

	@Override
	public UUser insertSelective(UUser entity) {
		userMapper.insertSelective(entity);
		return entity;
	}

	@Override
	public UUser selectByPrimaryKey(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(UUser entity) {
		return userMapper.updateByPrimaryKey(entity);
	}

	@Override
	public int updateByPrimaryKeySelective(UUser entity) {
		return userMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public UUser login(String email ,String pswd) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("pswd", pswd);
		UUser user = userMapper.login(map);
		return user;
	}

	@Override
	public UUser findUserByEmail(String email) {
		return userMapper.findUserByEmail(email);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<UUser> findByPage(Map<String, Object> resultMap,
			Integer pageNo, Integer pageSize) {
		return super.findPage(resultMap, pageNo, pageSize);
	}
	
	
	
}
