package com.sojson.core.tags;

import java.util.Map;

import org.apache.log4j.Logger;

import com.sojson.common.utils.StringUtils;
/**
 * 
 * 开发公司：WENYIFAN.NET<br/>
 * 版权：WENYIFAN.NET<br/>
 * <p>
 * 
 * <p>
 * 
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2014年5月13日 　<br/>
 * <p>
 *  自定义标签父类
 * <p>
 * @author zhou-baicheng
 * 
 * @version 1.0,2014年5月13日 <br/>
 * 
 */
@SuppressWarnings("unchecked")
public abstract class SuperCustomTag {
	protected final static Logger logger = Logger.getLogger(SuperCustomTag.class);
	protected abstract Object result(Map params);
	
	
	/**
	 * 直接强转报错，需要用Object过度一下
	 * @param e
	 * @return
	 */
	protected Long getLong(Map params,String key){
		Object i = params.get(key);
		return StringUtils.isBlank(i)?null:new Long(i.toString());
	}
	protected String getString(Map params,String key){
		Object i = params.get(key);
		return StringUtils.isBlank(i)?null:i.toString();
	}
	protected Integer getInt(Map params,String key){
		Object i = params.get(key);
		return StringUtils.isBlank(i)?null:Integer.parseInt(i.toString());
	}
}
