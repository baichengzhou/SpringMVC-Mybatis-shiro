package com.sojson.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sojson.common.controller.BaseController;
import com.sojson.common.model.SOUser;
import com.sojson.common.model.UUser;
import com.sojson.core.shiro.token.manager.TokenManager;
import com.sojson.user.service.SOUserService;

/**
 * 
 * 开发公司：itboy.net<br/>
 * 版权：itboy.net<br/>
 * <p>
 * 
 * 用户登录相关，不需要做登录限制
 * 
 * <p>
 * 
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2016年5月3日 　<br/>
 * <p>
 * *******
 * <p>
 * @author zhou-baicheng
 * @email  i@itboy.net
 * @version 1.0,2016年5月3日 <br/>
 * 
 */
@Controller
@Scope(value="prototype")
@RequestMapping("u")
public class UserLoginController extends BaseController {

	@Autowired
	SOUserService soUserService;
	/**
	 * 登录跳转
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.GET)
	public ModelAndView login(){
		
		return new ModelAndView("user/login");
	}
	/**
	 * 注册跳转
	 * @return
	 */
	@RequestMapping(value="register",method=RequestMethod.GET)
	public ModelAndView register(){
		
		return new ModelAndView("user/register");
	}
	@RequestMapping(value="subRegister",method=RequestMethod.GET)
	public ModelAndView subRegister(String vcode,UUser entity){
		
		return new ModelAndView("user/register");
	}
	/**
	 * 登录提交
	 * @return
	 */
	@RequestMapping(value="submitLogin",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> submitLogin(SOUser entity,Boolean rememberMe){
		try {
			entity = TokenManager.login(entity,rememberMe);
			resultMap.put("status", 200);
			resultMap.put("message", "登录成功");
			resultMap.put("back_url", "/user/index.shtml");
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "帐号或密码错误");
		}
		return resultMap;
	}
	/**
	 * 注册提交
	 * @return
	 */
	@RequestMapping(value="submitRegister",method=RequestMethod.POST)
	public ModelAndView submitRegister(){
		
		return new ModelAndView("user/register");
	}
	
	/**
	 * 退出
	 * @return
	 */
	@RequestMapping(value="logout",method =RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> logout(){
		try {
			TokenManager.logout();
			resultMap.put("status", 200);
		} catch (Exception e) {
			resultMap.put("status", 500);
			logger.error("errorMessage:" + e.getMessage());
			e.printStackTrace();
		}
		return resultMap;
	}
}
