package com.sojson.user.manager;

import com.sojson.common.model.UUser;
import com.sojson.common.utils.MathUtil;

public class UserManager {
	
	/**
	 * 加工密码，和登录一致。
	 * @param user
	 * @return
	 */
	public static UUser md5Pswd(UUser user){
		//密码为   email + '#' + pswd，然后MD5
		user.setPswd(md5Pswd(user.getEmail(),user.getPswd()));
		return user;
	}
	/**
	 * 字符串返回值
	 * @param email
	 * @param pswd
	 * @return
	 */
	public static String md5Pswd(String email ,String pswd){
		pswd = String.format("%s#%s", email,pswd);
		pswd = MathUtil.getMD5(pswd);
		return pswd;
	}
	
	
	
	
}
