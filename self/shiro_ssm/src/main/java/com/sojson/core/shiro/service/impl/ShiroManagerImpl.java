package com.sojson.core.shiro.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.core.io.ClassPathResource;

import com.sojson.common.utils.LoggerUtils;
import com.sojson.common.utils.StringUtils;
import com.sojson.core.config.INI4j;
import com.sojson.core.shiro.service.ShiroManager;

public class ShiroManagerImpl implements ShiroManager {
	
	// 注意/r/n前不能有空格
	private static final String CRLF = "\r\n";

	@Resource
	private ShiroFilterFactoryBean shiroFilterFactoryBean;


	@Override
	public String loadFilterChainDefinitions() {
		
		StringBuffer sb = new StringBuffer();
			sb.append(getFixedAuthRule());//固定权限，采用读取配置文件
			  //.append(getDynaAuthRule())//获取角色动态权限
//		  .append(getRestfulAuthRule())//其他自定义
//			  .append(LAST_AUTH_STR);
		return sb.toString();
	}
	/**
	

	 
	 */

	// 生成restful风格功能权限规则
	private String getRestfulAuthRule() {
		/*
	   List<Auth> auths = dao.getAuths(null);
	   
	   Set<String> restfulUrls = new HashSet<String>();
	   for(Auth au : auths) {
	       restfulUrls.add(au.getUrl());
	       
	   }
	   StringBuffer sb  = new StringBuffer("");
	   for(Iterator<String> urls =  restfulUrls.iterator(); urls.hasNext(); ) {
	       String url = urls.next();
	       if(! url.startsWith("/")) {
	          url = "/"+ url ;
	       }
	       sb.append(url).append(" = ").append("authc,rest[").append(url).append("]").append(CRLF);
	   }
	   return sb.toString();
	   */
		return "";
	}

	
	
	// 根据角色，得到动态权限规则
	private String getDynaAuthRule() {
	   StringBuffer sb = new StringBuffer("");
	   
	   /**
	    * 从Session里取到当前的地址
	    * 
	    * 更新地址权限配置
	    * 
	    */
	   
	   //TODO--- 模拟初始化地址
	   
	   sb.append("/shiro/index_1.html = authc,permissionCheck[/shiro/index_1.html]").append(CRLF);
	   sb.append("/shiro/index_2.html = authc,permissionCheck[/shiro/index_2.html]").append(CRLF);
	   sb.append("/shiro/index_3.html = authc,permissionCheck[/shiro/index_3.html]").append(CRLF);
	   
	  
	   
	   /*
	   
	   
	   try {
		   Session session = SecurityUtils.getSubject().getSession();
		   
		   String [] link = (String[]) session.getAttribute("link");
		   
		   for(String url :link){
			   if(!url.startsWith("/")) {
	              url = "/"+ url;
	           }
			   sb.append(url).append(" = ").append("authc,permissionCheck").append("["+url+"]").append(CRLF);
		   }
	   } catch (Exception e) {
			e.printStackTrace();
	   }
	   */
	   
//	   Map<String, Set<String>> rules = new HashMap<String,Set<String>>();
	   
//	   List<Role> roles = dao.queryEntitys("from Role r left join fetch r.menus", new Object[]{});
//	   for(Role role: roles) {
//	       for(Iterator<Menu> menus =role.getMenus().iterator(); menus.hasNext();) {
//	          String url = menus.next().getUrl();
//	          if(!url.startsWith("/")) {
//	              url = "/"+ url;
//	          }
//	          if(!rules.containsKey(url)) {
//	              rules.put(url, new HashSet<String>());
//	          }
//	          rules.get(url).add((role.getRoleCode()));
//	       }
//	   }
//	   
//	   for(Map.Entry<String, Set<String>> entry :rules.entrySet()) {
//	       sb.append(entry.getKey()).append(" = ").append("authc,roleOrFilter").append(entry.getValue()).append(CRLF);
//	   }
   
	   return sb.toString();
	}
	
	/**
	 * 从配额文件获取固定权限验证规则串
	 */
	private String getFixedAuthRule(){
		StringBuffer sb = new StringBuffer("");
		ClassPathResource cp = new ClassPathResource("shiro_base_auth.ini");
		INI4j ini = null;
		try {
			ini = new INI4j(cp.getFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String section = "base_auth";
		Set<String> keys = ini.get(section).keySet();
		for (String key : keys) {
			String value = ini.get(section, key);
			sb.append(key).append(" = ")
			.append(value).append(CRLF);
		}
		
		return sb.toString();

	}

	// 此方法加同步锁
	@Override
	public synchronized void reCreateFilterChains() {
//		ShiroFilterFactoryBean shiroFilterFactoryBean = (ShiroFilterFactoryBean) SpringContextUtil.getBean("shiroFilterFactoryBean");
		AbstractShiroFilter shiroFilter = null;
		try {
			shiroFilter = (AbstractShiroFilter) shiroFilterFactoryBean.getObject();
		} catch (Exception e) {
			LoggerUtils.error(getClass(),"getShiroFilter from shiroFilterFactoryBean error!", e);
			throw new RuntimeException("get ShiroFilter from shiroFilterFactoryBean error!");
		}

		PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter
				.getFilterChainResolver();
		DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver
				.getFilterChainManager();

		// 清空老的权限控制
		manager.getFilterChains().clear();

		shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();
		shiroFilterFactoryBean.setFilterChainDefinitions(loadFilterChainDefinitions());
		// 重新构建生成
		Map<String, String> chains = shiroFilterFactoryBean
				.getFilterChainDefinitionMap();
		for (Map.Entry<String, String> entry : chains.entrySet()) {
			String url = entry.getKey();
			String chainDefinition = entry.getValue().trim().replace(" ", "");
			manager.createChain(url, chainDefinition);
		}

	}
	public void setShiroFilterFactoryBean(
			ShiroFilterFactoryBean shiroFilterFactoryBean) {
		this.shiroFilterFactoryBean = shiroFilterFactoryBean;
	}

}
