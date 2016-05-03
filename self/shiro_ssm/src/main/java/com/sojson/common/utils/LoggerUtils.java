package com.sojson.common.utils;

import org.apache.log4j.Logger;
/**
 * 
 * 开发公司：九樱天下<br/>
 * 版权：九樱天下<br/>
 * <p>
 * 
 * <p>
 * 
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2014年7月30日 　<br/>
 * <p>
 * Logger 工具类
 * <p>
 * @author zhou-baicheng
 * 
 * @version 1.0,2014年7月30日 <br/>
 * 
 */
public class LoggerUtils {
	/**
	 * 是否开启Debug
	 */
	public static boolean isDebug =  Logger.getLogger(LoggerUtils.class).isDebugEnabled();
	
	/**
	 * Debug 输出
	 * @param clazz  	目标.Class
	 * @param message	输出信息
	 */
	public static void debug(Class<? extends Object> clazz ,String message){
		if(!isDebug)return ;
		Logger logger = Logger.getLogger(clazz);
		logger.debug(message);
	}
	/**
	 * Debug 输出
	 * @param clazz  	目标.Class
	 * @param fmtString 输出信息key
	 * @param value		输出信息value
	 */
	public static void fmtDebug(Class<? extends Object> clazz,String fmtString,Object...value){
		if(!isDebug)return ;
		if(StringUtils.isBlank(fmtString)){
			return ;
		}
		if(null != value && value.length != 0){
			fmtString = String.format(fmtString, value);
		}
		debug(clazz, fmtString);
	}
	/**
	 * Error 输出
	 * @param clazz  	目标.Class
	 * @param message	输出信息
	 * @param e			异常类
	 */
	public static void error(Class<? extends Object> clazz ,String message,Exception e){
		Logger logger = Logger.getLogger(clazz);
		if(null == e){
			logger.error(message);
			return ;
		}
		logger.error(message, e);
	}
	/**
	 * Error 输出
	 * @param clazz  	目标.Class
	 * @param message	输出信息
	 */
	public static void error(Class<? extends Object> clazz ,String message){
		error(clazz, message, null);
	}
	/**
	 * 异常填充值输出
	 * @param clazz 	目标.Class
	 * @param fmtString	输出信息key
	 * @param e			异常类
	 * @param value		输出信息value
	 */
	public static void fmtError(Class<? extends Object> clazz,Exception e,String fmtString,Object...value){
		if(StringUtils.isBlank(fmtString)){
			return ;
		}
		if(null != value && value.length != 0){
			fmtString = String.format(fmtString, value);
		}
		error(clazz, fmtString, e);
	}
	/**
	 * 异常填充值输出
	 * @param clazz		目标.Class
	 * @param fmtString 输出信息key
	 * @param value		输出信息value
	 */
	public static void fmtError(Class<? extends Object> clazz,
			String fmtString, Object...value) {
		if(StringUtils.isBlank(fmtString)){
			return ;
		}
		if(null != value && value.length != 0){
			fmtString = String.format(fmtString, value);
		}
		error(clazz, fmtString);
	}
}
