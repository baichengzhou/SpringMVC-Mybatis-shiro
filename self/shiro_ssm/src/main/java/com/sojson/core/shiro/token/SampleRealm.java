package com.sojson.core.shiro.token;

import java.util.Set;
import java.util.TreeSet;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.sojson.common.model.SOUser;
import com.sojson.user.service.SOUserService;


/**
 * 
 * 开发公司：WENYIFAN.NET<br/>
 * 版权：WENYIFAN.NET<br/>
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
	SOUserService userService;
	
	public SampleRealm() {
		super();
	}
	/**
	 *  认证信息，主要针对用户登录， 
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		
		ShiroToken token = (ShiroToken) authcToken;
		SOUser user = userService.findLogin(token.getUsername(),token.getPswd());
		if(null == user){
			throw new AccountException("帐号或密码不正确！");
		}
		return new SimpleAuthenticationInfo(user,user.getPassword(), getName());
    }

	 /** 
     * 授权 
     */  
    @Override  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {  
    	Subject currentUser = SecurityUtils.getSubject();
    	SOUser user = (SOUser) currentUser.getPrincipal();
    	Set<String> roles = new TreeSet<String>();
    	roles.add("role:" + user.getLevel());
		SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
		info.setRoles(roles);
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
