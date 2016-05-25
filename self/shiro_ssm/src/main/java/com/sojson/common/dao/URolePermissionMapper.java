package com.sojson.common.dao;

import com.sojson.common.model.URolePermission;

public interface URolePermissionMapper {
    int insert(URolePermission record);

    int insertSelective(URolePermission record);
}