package com.sojson.core.shiro.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

import com.sojson.common.model.SOUser;
import com.sojson.common.utils.LoggerUtils;
import com.sojson.core.shiro.token.manager.TokenManager;

public class LoginFilter  extends AccessControlFilter {
	final static Class<LoginFilter> CLASS = LoginFilter.class;
	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		HttpServletResponse hresponse = (HttpServletResponse)response;
		HttpServletRequest hrequest = (HttpServletRequest)request;		
		Map<String,String> resultMap = new HashMap<String, String>();
		SOUser token = TokenManager.getToken();
		
		Subject subject = getSubject(request, response);
		if(token!=null || isLoginRequest(request, response)){// && isEnabled()
            return true;
        } else {
            if(null == token){
            	token = (SOUser) subject.getPrincipal();
            	  if(token != null){
      				if ("XMLHttpRequest".equalsIgnoreCase(hrequest.getHeader("X-Requested-With"))) {// ajax请求
      				  resultMap.put("login_status", "100");
             			  resultMap.put("message", "当前用户已经被禁止！");
      				}else{
      					 return false ;
      				}
      				LoggerUtils.debug(CLASS,"info success!!!");
            	  }else{
            		
            		  if ("XMLHttpRequest".equalsIgnoreCase(hrequest.getHeader("X-Requested-With"))) {// ajax请求
            			  LoggerUtils.debug(getClass(), "当前用户没有登录，并且是Ajax请求！");
	        			  resultMap.put("login_status", "300");
	        			  resultMap.put("message", "当前用户没有登录！");
            			  out(hresponse, resultMap);
    				  } else{
    					  LoggerUtils.debug(getClass(), "当前用户没有登录，并且普通的HTTP请求！");
    				  }
            		  return false ;
            	  }
            }else{
            	 LoggerUtils.debug(CLASS,"info success!!!");
            }
        }
            return true;
		
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
			throws Exception {
		saveRequestAndRedirectToLogin(request, response);
		return false;
	}
	
	private void out(HttpServletResponse hresponse,Map<String,String> resultMap) throws IOException{
		hresponse.setCharacterEncoding("UTF-8");
		PrintWriter out = hresponse.getWriter();
	  
		out.println(JSONObject.fromObject(resultMap).toString());
		out.flush();
		out.close();
	}
	
	

}
