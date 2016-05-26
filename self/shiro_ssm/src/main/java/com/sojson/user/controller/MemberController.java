package com.sojson.user.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sojson.common.controller.BaseController;
import com.sojson.common.model.UUser;
import com.sojson.core.mybatis.page.Pagination;
import com.sojson.core.shiro.CustomShiroSessionDAO;
import com.sojson.core.shiro.cache.JedisShiroSessionRepository;
import com.sojson.user.bo.UserOnlineBo;
import com.sojson.user.manager.UserManager;
import com.sojson.user.service.UUserService;

import freemarker.ext.beans.MapModel;
/**
 * 
 * 开发公司：itboy.net<br/>
 * 版权：itboy.net<br/>
 * <p>
 * 
 * 用户会员管理
 * 
 * <p>
 * 
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2016年5月26日 　<br/>
 * <p>
 * *******
 * <p>
 * @author zhou-baicheng
 * @email  i@itboy.net
 * @version 1.0,2016年5月26日 <br/>
 * 
 */
@Controller
@Scope(value="prototype")
@RequestMapping("member")
public class MemberController extends BaseController {

	@Autowired
	CustomShiroSessionDAO customShiroSessionDAO;
	@Resource
	UUserService userService;
	/**
	 * 用户列表管理
	 * @return
	 */
	@RequestMapping(value="list")
	public ModelAndView list(ModelMap map,Integer pageNo,String findContent){
		map.put("findContent", findContent);
		Pagination<UUser> page = userService.findByPage(resultMap,pageNo,pageSize);
		map.put("page", page);
		return new ModelAndView("member/list");
	}
	/**
	 * 在线用户管理
	 * @return
	 */
	@RequestMapping(value="online",method=RequestMethod.GET)
	public ModelAndView online(){
		List<UserOnlineBo> list = UserManager.getAllUser(customShiroSessionDAO);
		return new ModelAndView("member/online","list",list);
	}
}
