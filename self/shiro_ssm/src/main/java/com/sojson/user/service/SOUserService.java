package com.sojson.user.service;

import com.sojson.common.model.SOUser;

public interface SOUserService {

	int deleteByPrimaryKey(Long id);

	SOUser insert(SOUser record);

	SOUser insertSelective(SOUser record);

    SOUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SOUser record);

    int updateByPrimaryKey(SOUser record);

	SOUser findLogin(String email, String password);
}
