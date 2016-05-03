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
	
	@SuppressWarnings("unchecked")
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
//		if(null != token && token.getId() != null){
//			model.put("id", token.getId());
//		}
		
		//String ip = IPUtils.getIP(request);
		
		//特效是否禁止
		Object texiao = CookieUtil.findCookieByName(request, "_texiao");
		if(StringUtils.isBlank(texiao)){
			texiao = Boolean.TRUE;
		}else{
			texiao = Boolean.parseBoolean((String)texiao);
		}
		model.put("_texiao", texiao);
		
		//是否显示禁止右键和保存
		String key = VCache.get(OFFKey, String.class);
		if(StringUtils.isNotBlank(key)){
			model.put("off", key);
		}else{
			model.put("off", "open");
		}
		
		model.put("token", token);
		model.put("_time", new Date().getTime());
		model.put("NOW_YEAY", Constant.NOW_YEAY);
		
		model.put("_v", Constant.VERSION);//版本号，重启的时间
		model.put("domain_www", Constant.DOMAIN_WWW);//前端域名
		model.put("cdn", Constant.DOMAIN_CDN);//CDN域名
		
		
//		model.put("_version", WYFConfig.get("version"));
	}
}
