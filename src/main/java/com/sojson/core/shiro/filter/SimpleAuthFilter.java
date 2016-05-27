package com.sojson.core.shiro.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import com.sojson.common.utils.LoggerUtils;
import com.sojson.core.shiro.session.CustomSessionManager;
import com.sojson.core.shiro.session.SessionStatus;

/**
 * 
 * 开发公司：itboy.net<br/>
 * 版权：itboy.net<br/>
 * <p>
 * 
 * 
 * 
 * <p>
 * 
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2016年5月27日 　<br/>
 * <p>
 * *******
 * <p>
 * 
 * @author zhou-baicheng
 * @email i@itboy.net
 * @version 1.0,2016年5月27日 <br/>
 * 
 */
public class SimpleAuthFilter extends AccessControlFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {

		HttpServletRequest httpRequest = ((HttpServletRequest)request);
		String url = httpRequest.getRequestURI();
		if(url.startsWith("/open/")){
			return Boolean.TRUE;
		}
		Subject subject = getSubject(request, response);
		Session session = subject.getSession();
		Map<String, String> resultMap = new HashMap<String, String>();
		SessionStatus sessionStatus = (SessionStatus) session.getAttribute(CustomSessionManager.SESSION_STATUS);
		if (null != sessionStatus && !sessionStatus.isOnlineStatus()) {
			//判断是不是Ajax请求
			if (ShiroFilterUtils.isAjax(request) ) {
				LoggerUtils.debug(getClass(), "当前用户已经被踢出，并且是Ajax请求！");
				resultMap.put("user_status", "300");
				resultMap.put("message", "当前用户已经被踢出！");
				out(response, resultMap);
			}
			return  Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		
		WebUtils.getSavedRequest(request);
		WebUtils.issueRedirect(request, response, "/open/kickedOut.shtml");
		return false;
	}

	private void out(ServletResponse hresponse, Map<String, String> resultMap)
			throws IOException {
		hresponse.setCharacterEncoding("UTF-8");
		PrintWriter out = hresponse.getWriter();
		out.println(JSONObject.fromObject(resultMap).toString());
		out.flush();
		out.close();
	}
}
