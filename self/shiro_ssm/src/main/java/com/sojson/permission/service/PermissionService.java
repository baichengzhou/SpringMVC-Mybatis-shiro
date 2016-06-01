package com.sojson.permission.service;

import java.util.List;
import java.util.Map;

import com.sojson.common.model.UPermission;
import com.sojson.core.mybatis.page.Pagination;
import com.sojson.permission.bo.UPermissionBo;

public interface PermissionService {

	int deleteByPrimaryKey(Long id);

	UPermission insert(UPermission record);

    UPermission insertSelective(UPermission record);

    UPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UPermission record);

    int updateByPrimaryKey(UPermission record);

	Map<String, Object> deletePermissionById(String ids);

	Pagination<UPermission> findPage(Map<String,Object> resultMap, Integer pageNo,
			Integer pageSize);
	List<UPermissionBo> selectPermissionById(Long id);
}
