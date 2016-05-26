package com.sojson.user.service;

import java.util.Map;

import com.sojson.common.model.UUser;
import com.sojson.core.mybatis.page.Pagination;

public interface UUserService {

	int deleteByPrimaryKey(Long id);

	UUser insert(UUser record);

    UUser insertSelective(UUser record);

    UUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UUser record);

    int updateByPrimaryKey(UUser record);
    
    UUser login(String email ,String pswd);

	UUser findUserByEmail(String email);

	Pagination<UUser> findByPage(Map<String, Object> resultMap, Integer pageNo,
			Integer pageSize);
}
