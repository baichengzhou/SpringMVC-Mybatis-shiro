package com.sojson.core.freemarker.extend;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import com.sojson.common.model.SOUser;
import com.sojson.common.utils.CookieUtil;
import com.sojson.common.utils.StringUtils;
import com.sojson.core.shiro.cache.VCache;
import com.sojson.core.shiro.token.manager.TokenManager;
import com.sojson.core.statics.Constant;
public class FreeMarkerViewExtend extends FreeMarkerView {
	//右键开关
	final static  String OFFKey = "RIGHT_MENU_OFF";
	
	protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request){
		
		try {
			super.exposeHelpers(model, request);
		} catch (Exception e) {
			e.printStackTrace();
//			throw e;
		}
		model.put(Constant.CONTEXT_PATH, request.getContextPath());
		model.putAll(Ferrmarker.initMap);
		SOUser token = TokenManager.getToken();
		//String ip = IPUtils.getIP(request);
		model.put("token", token);
		model.put("_time", new Date().getTime());
		model.put("NOW_YEAY", Constant.NOW_YEAY);
		
		model.put("_v", Constant.VERSION);//版本号，重启的时间
		model.put("domain_www", Constant.DOMAIN_WWW);//前端域名
		model.put("cdn", Constant.DOMAIN_CDN);//CDN域名
		
		
//		model.put("_version", WYFConfig.get("version"));
	}
}
