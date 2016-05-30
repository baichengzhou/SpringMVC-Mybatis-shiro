package com.sojson.permission.controller;

import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sojson.common.controller.BaseController;
import com.sojson.common.model.URole;
import com.sojson.common.utils.LoggerUtils;
import com.sojson.core.mybatis.page.Pagination;
import com.sojson.permission.service.RoleService;
/**
 * 
 * 开发公司：itboy.net<br/>
 * 版权：itboy.net<br/>
 * <p>
 * 
 * 用户角色管理
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
@RequestMapping("role")
public class RoleController extends BaseController {
	@Autowired
	RoleService roleService;
	/**
	 * 角色列表
	 * @return
	 */
	@RequestMapping(value="index")
	public ModelAndView index(String findContent,ModelMap modelMap){
		modelMap.put("findContent", findContent);
		Pagination<URole> role = roleService.findPage(modelMap,pageNo,pageSize);
		return new ModelAndView("role/index","page",role);
	}
	/**
	 * 角色添加
	 * @param role
	 * @return
	 */
	@RequestMapping(value="addRole",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addRole(URole role){
		try {
			int count = roleService.insertSelective(role);
			resultMap.put("status", 200);
			resultMap.put("successCount", count);
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "添加失败，请刷新后再试！");
			LoggerUtils.fmtError(getClass(), e, "添加角色报错。source[%s]", JSONObject.fromObject(role).toString());
		}
		return resultMap;
	}
	/**
	 * 删除角色，根据ID，但是删除角色的时候，需要查询是否有赋予给用户，如果有用户在使用，那么就不能删除。
	 * @param id
	 * @return
	 */
	@RequestMapping(value="deleteRoleById",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteRoleById(String ids){
		return roleService.deleteRoleById(ids);
	}
}
