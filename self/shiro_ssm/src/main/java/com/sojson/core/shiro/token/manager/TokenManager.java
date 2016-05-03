package com.sojson.core.shiro.token.manager;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import com.sojson.common.model.SOUser;
import com.sojson.core.shiro.token.ShiroToken;



/**
 * 
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
 * @version 1.0,2014年3月3日 
 * 
 * Shiro管理下的Token工具类
 */
public class TokenManager {
	
	public static final String TOKEN_KEY = "sojson_token_key";
	
	/*奶牛使用 start*/
//	public static final String TOKEN = "token" ,MENU = "menu";
	//private static Logger log = Logger.getLogger(TokenManager.class);
	/*奶牛使用 end*/
	/**
	 * 获取当前登录的用户User对象
	 * @return
	 */
	public static SOUser getToken(){
		SOUser token = (SOUser)SecurityUtils.getSubject().getPrincipal();
		return token ;
	}
	
	
	
	/**
	 * 获取当前用户的Session
	 * @return
	 */
	public static Session getSession(){
		return SecurityUtils.getSubject().getSession();
	}
	/**
	 * 获取当前用户NAME
	 * @return
	 */
	public static String getNickname(){
		return getToken().getNickname();
	}
	/**
	 * 获取当前用户ID
	 * @return
	 */
	public static Long getUserId(){
		return getToken()==null?null:getToken().getId();
	}
	/**
	 * 把值放入到当前登录用户的Session里
	 * @param key
	 * @param value
	 */
	public static void setVal2Session(Object key ,Object value){
		getSession().setAttribute(key, value);
	}
	/**
	 * 从当前登录用户的Session里取值
	 * @param key
	 * @return
	 */
	public static Object getVal2Session(Object key){
		return getSession().getAttribute(key);
	}
	/**
	 * 获取验证码，获取一次后删除
	 * @return
	 */
	public static String getYZM(){
		String code = (String) getSession().getAttribute("CODE");
		getSession().removeAttribute("CODE");
		return code ;
	}
	
	
	/**
	 * 获取当前用户的roles
	 * @return
	 */
	
	public static SOUser login(SOUser user){
		ShiroToken token = new ShiroToken(user.getEmail(), user.getPassword());
		token.setRememberMe(Boolean.TRUE);
		SecurityUtils.getSubject().login(token);
		return getToken();
	}


	/**
	 * 判断是否登录
	 * @return
	 */
	public static boolean isLogin() {
		return null != SecurityUtils.getSubject().getPrincipal();
	}
	/**
	 * 退出登录
	 */
	public static void logout() {
		SecurityUtils.getSubject().logout();
	}
	
}
