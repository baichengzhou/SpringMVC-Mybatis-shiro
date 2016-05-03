package com.sojson.core.tags;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.util.HashMap;
import java.util.Map;

import com.sojson.common.utils.SpringContextUtil;
import com.sojson.core.statics.Constant;

import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

/**
 * 
 * 开发公司：九樱天下<br/>
 * 版权：九樱天下<br/>
 * <p>
 * 
 * <p>
 * 
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2014年5月13日 　<br/>
 * <p>
 * API公共入口
 * <p>
 * @author zhou-baicheng
 * 
 * @version 1.0,2014年5月13日 <br/>
 * 
 */
public class APITemplateModel extends WYFTemplateModel {

	@Override
	@SuppressWarnings({  "unchecked" })
	protected Map<String, TemplateModel> putValue(Map params)
			throws TemplateModelException {
		
		Map<String, TemplateModel> paramWrap = null ;
		if(null != params && params.size() != 0 || null != params.get(Constant.TARGET)){
			String name =  params.get(Constant.TARGET).toString() ;
			paramWrap = new HashMap<String, TemplateModel>(params);
			SuperCustomTag tag =  SpringContextUtil.getBean(name,SuperCustomTag.class);
			Object result = tag.result(params);
			paramWrap.put(Constant.OUT_TAG_NAME, DEFAULT_WRAPPER.wrap(result));
		}else{
			
			throw new RuntimeException("Cannot be null, must include a 'name' attribute!");
			/*
			WYFException(
					new RuntimeException("Cannot be null, must include a 'name' attribute!"),
					this.getClass()
			);
			*/
		}
		return paramWrap;
	}

	
	
	
	
	
}
