package com.sojson.core.shiro.token;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
import com.sojson.core.shiro.token.manager.TokenManager;
import com.sojson.permission.service.PermissionService;
import com.sojson.permission.service.RoleService;
import com.sojson.user.service.UUserService;


/**
 * 
 * 开发公司：SOJSON在线工具 <p>
 * 版权所有：© www.sojson.com<p>
 * 博客地址：http://www.sojson.com/blog/  <p>
 * <p>
 * 
 * shiro 认证 + 授权   重写
 * 
 * <p>
 * 
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2016年6月2日 　<br/>
 *
 * @author zhou-baicheng
 * @email  so@sojson.com
 * @version 1.0,2016年6月2日 <br/>
 * 
 */
public class SampleRealm extends AuthorizingRealm {

	@Autowired
	UUserService userService;
	@Autowired
	PermissionService permissionService;
	@Autowired
	RoleService roleService;
	
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
		/**
		 * 如果用户的status为禁用。那么就抛出<code>DisabledAccountException</code>
		 */
		}else if(UUser._0.equals(user.getStatus())){
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
    	Long userId = TokenManager.getUserId();
		SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
		Set<String> roles = roleService.findRoleByUserId(userId);
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
