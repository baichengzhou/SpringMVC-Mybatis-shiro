package com.sojson.core.config;

import java.io.IOException;
import java.util.Properties;

public class QQConfig {

	/**
	 * 同步锁
	 */
	private static final Object obj = new Object();
	
	/**
	 * 配置文件
	 */
	private static Properties prop = null;
	
	/**
	 * 配置对象单例模式
	 */
	private static QQConfig config = null;
	
	/**
	 * 配置文件名称
	 */
	private final static String FILE_NAME = "/qqconnectconfig.properties";
	
	static{
		prop = new Properties();
		try {
			prop.load(QQConfig.class.getResourceAsStream(FILE_NAME));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 获取单例模式对象实例
	 * @return 唯一对象实例
	 */
	public static QQConfig getInstance(){
		if(null==config){
			synchronized (obj) {
				config = new QQConfig();
			}
		}
		return config;
	}
	
	/**
	 */
	public static String get(String key){
		return prop.getProperty(key);
	}
	
}
