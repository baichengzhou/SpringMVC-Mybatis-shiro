package com.sojson.common.timer;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * 定时任务恢复数据
 *
 */
@Component
public class ToTimer{
	
//	@Resource
//	RoleService roleService;
	
	@Scheduled(cron = "0/5 * * * * ? ")
	public void run() {
//		org.springframework.scheduling.TaskScheduler
		/**
		 * 调用存储过程，重新创建表，插入初始化数据。
		 */
//		roleService.initData();
		System.out.println(new Date().getTime());
	}

	
	
	
	
	
	
}
