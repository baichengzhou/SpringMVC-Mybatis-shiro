package com.sojson.permission.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sojson.common.dao.UPermissionMapper;
import com.sojson.common.dao.URolePermissionMapper;
import com.sojson.common.dao.UUserMapper;
import com.sojson.common.model.UPermission;
import com.sojson.common.model.URolePermission;
import com.sojson.common.utils.LoggerUtils;
import com.sojson.common.utils.StringUtils;
import com.sojson.core.mybatis.BaseMybatisDao;
import com.sojson.core.mybatis.page.Pagination;
import com.sojson.permission.service.PermissionService;
@Service
public class PermissionServiceImpl extends BaseMybatisDao<UPermissionMapper> implements PermissionService {

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

	@Override
	public Map<String, Object> deletePermissionById(String ids) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			int successCount=0,errorCount=0;
			String resultMsg ="删除%s条，失败%s条";
			String[] idArray = new String[]{};
			if(StringUtils.contains(ids, ",")){
				idArray = ids.split(",");
			}else{
				idArray = new String[]{ids};
			}
			
			c:for (String idx : idArray) {
				Long id = new Long(idx);
				
				List<URolePermission> rolePermissions= rolePermissionMapper.findRolePermissionByPid(id);
				if(null != rolePermissions && rolePermissions.size() > 0){
					errorCount+=rolePermissions.size();
					continue c;
				}else{
					successCount+=this.deleteByPrimaryKey(id);
				}
			}
			resultMap.put("status", 200);
			//如果有成功的，也有失败的，提示清楚。
			if(successCount > 0 && errorCount > 0){
				resultMsg = String.format(resultMsg, successCount,errorCount);
			}else{
				resultMsg = "操作成功";
			}
			resultMap.put("resultMsg", resultMsg);
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "根据IDS删除用户出现错误，ids[%s]", ids);
			resultMap.put("status", 500);
			resultMap.put("message", "删除出现错误，请刷新后再试！");
		}
		return resultMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<UPermission> findPage(Map<String,Object> resultMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(resultMap, pageNo, pageSize);
	}

	
}
