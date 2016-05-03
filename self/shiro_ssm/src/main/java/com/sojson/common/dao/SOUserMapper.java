package com.sojson.common.dao;

import java.util.Map;

import com.sojson.common.model.SOUser;

public interface SOUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SOUser record);

    int insertSelective(SOUser record);

    SOUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SOUser record);

    int updateByPrimaryKey(SOUser record);

	SOUser findLogin(Map<String, Object> map);
}