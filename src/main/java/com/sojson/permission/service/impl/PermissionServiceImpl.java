package com.sojson.permission.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sojson.common.dao.UPermissionMapper;
import com.sojson.common.dao.URolePermissionMapper;
import com.sojson.common.dao.UUserMapper;
import com.sojson.common.model.UPermission;
import com.sojson.permission.service.PermissionService;
@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	UPermissionMapper permissionMapper;
	@Autowired
	UUserMapper userMapper;
	@Autowired
	URolePermissionMapper rolePermissionMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return permissionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public UPermission insert(UPermission record) {
		permissionMapper.insert(record);
		return record;
	}

	@Override
	public UPermission insertSelective(UPermission record) {
		permissionMapper.insertSelective(record);
		return record;
	}

	@Override
	public UPermission selectByPrimaryKey(Long id) {
		return permissionMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(UPermission record) {
		return permissionMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(UPermission record) {
		return permissionMapper.updateByPrimaryKeySelective(record);
	}
	
}
