package com.sojson.user.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;

import com.sojson.common.model.UUser;
import com.sojson.common.utils.MathUtil;
import com.sojson.core.shiro.CustomShiroSessionDAO;
import com.sojson.user.bo.UserOnlineBo;

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
	/**
	 * 获取所有的有效Session用户
	 * @param jedisShiroSessionRepository
	 * @return
	 */
	public static List<UserOnlineBo> getAllUser(
			CustomShiroSessionDAO sessionDao) {
		
		Collection<Session> sessions = sessionDao.getActiveSessions();
		List<UserOnlineBo> list = new ArrayList<UserOnlineBo>();
		for (Session session : sessions) {
			Object obj = session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
			if(null == obj){
				continue ;
			}
			if(obj instanceof SimplePrincipalCollection){
				SimplePrincipalCollection spc = (SimplePrincipalCollection)obj;
				obj = spc.getPrimaryPrincipal();
				if(null != obj && obj instanceof UUser){
					UserOnlineBo userBo = new UserOnlineBo((UUser)obj);
					userBo.setLastAccess(session.getLastAccessTime());
					userBo.setHost(session.getHost());
					userBo.setSessionId(session.getId().toString());
					userBo.setLastLoginTime(session.getStartTimestamp());
					userBo.setTimeout(session.getTimeout());
					list.add(userBo);
				}
			}
		}
		
		return list;
	}
}
