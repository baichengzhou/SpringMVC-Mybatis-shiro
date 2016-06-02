package com.sojson.common.dao;

import java.util.Set;

import com.sojson.common.model.URole;

public interface URoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(URole record);

    int insertSelective(URole record);

    URole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(URole record);

    int updateByPrimaryKey(URole record);

	Set<String> findRoleByUserId(Long id);
}