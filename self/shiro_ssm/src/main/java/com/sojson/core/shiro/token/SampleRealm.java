package com.sojson.core.shiro.token;

import java.util.Date;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.sojson.common.model.UUser;
import com.sojson.user.service.UUserService;


/**
 * 
 * 开发公司：sojson.com<br/>
 * 版权：sojson.com<br/>
 * <p>
 * 
 * <p>
 * 
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2014年3月3日 　<br/>
 * <p>
 * 
 * @author zhou-baicheng
 * 
 * @version 1.0,2014年3月3日 <br/>
 * 
 * shiro 认证 + 授权   重写
 */
public class SampleRealm extends AuthorizingRealm {

	@Autowired
	UUserService userService;
	
	public SampleRealm() {
		super();
	}
	/**
	 *  认证信息，主要针对用户登录， 
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		
		ShiroToken token = (ShiroToken) authcToken;
		UUser user = userService.login(token.getUsername(),token.getPswd());
		if(null == user){
			throw new AccountException("帐号或密码不正确！");
		}else if(new Long(0).equals(user.getStatus())){
			throw new DisabledAccountException("帐号已经禁止登录！");
		}else{
			//更新登录时间 last login time
			user.setLastLoginTime(new Date());
			userService.updateByPrimaryKeySelective(user);
		}
		return new SimpleAuthenticationInfo(user,user.getPswd(), getName());
    }

	 /** 
     * 授权 
     */  
    @Override  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {  
//    	Subject currentUser = SecurityUtils.getSubject();
//    	UUser user = (UUser) currentUser.getPrincipal();
//    	Set<String> roles = new TreeSet<String>();
//    	roles.add("role:" + user.getLevel());
		SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
//		info.setRoles(roles);
        return info;  
    }  
    /** 
     * 异常转换 
     * @param e 
     * @return 
     */  
//    private AuthenticationException translateAuthenticationException(Exception e) {  
//        if (e instanceof AuthenticationException) {  
//            return (AuthenticationException) e;  
//        }  
//        if(e instanceof DisabledAccountException){  
//            return (DisabledAccountException)e;  
//        }  
//        if(e instanceof UnknownAccountException){  
//            return (UnknownAccountException)e;  
//        }  
//        return new AuthenticationException(e);  
//    } 
    
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principal, getName());
		clearCachedAuthorizationInfo(principals);
	}
}
