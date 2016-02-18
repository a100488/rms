package com.anwei.rms.web.rest;

import java.text.ParseException;
import java.util.Map;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.anwei.rms.pojo.domain.UserDomain;
import com.anwei.rms.pojo.model.PagingCondition;
import com.anwei.rms.pojo.model.role.UserModel;
import com.anwei.rms.service.UserService;
import com.anwei.rms.util.constant.BaseUrl;
import com.anwei.rms.util.constant.CodeConstant;

@Controller
public class RestUserController {
	@Autowired
	UserService userService;
	@RequestMapping(value = "/rest/user/user-list.json", method = RequestMethod.GET)
	public String getRoleList(@RequestParam Map<String, String> params, ModelMap modelMap) throws ParseException {
		UserDomain searchDomain=new UserDomain();
		PagingCondition<UserDomain> condition = new PagingCondition<UserDomain>(
				params, searchDomain);
		if (condition.hasFilter()) {
			searchDomain.setName(condition.getFilter());
		}
		UserModel userModel = new UserModel();
		userModel.setData(userService.selectUserList(condition));
		userModel.setCondition(condition);
		modelMap.addAttribute(userModel);
		return BaseUrl.VIEW_LOC_JSON;
	}
	@RequestMapping(value = "/rest/user/user.json", method = RequestMethod.POST)
	@RequiresPermissions("addUser")
	public String saveUser(@Valid @RequestBody UserModel userModel, ModelMap modelMap) {
		
		UserDomain userDomain=new UserDomain();
		userDomain.setDeleteFlag(CodeConstant.CODE_CONSTANT_DELETEFLAG_0);
		userDomain.setName(userModel.getName());
		userDomain.setUserName(userModel.getUserName());
		userDomain.setPassword(userModel.getPassword());
		userDomain.setRoleIds(userModel.getRoleIds());
		userService.insertUser(userDomain);
		return BaseUrl.VIEW_LOC_JSON;

	}
	@RequestMapping(value = "/rest/user/user.json", method = RequestMethod.PUT)
	@RequiresPermissions("editUser")
	public String updateUser(@Valid @RequestBody UserModel userModel, ModelMap modelMap) {
		UserDomain userDomain=new UserDomain();
		userDomain.setUuid(userModel.getUuid());
		userDomain.setName(userModel.getName());
		userDomain.setUserName(userModel.getUserName());
		userDomain.setRoleIds(userModel.getRoleIds());
		userService.updateUser(userDomain);
		return BaseUrl.VIEW_LOC_JSON;

	}
	@RequiresPermissions("isDisableUser")
	@RequestMapping(value = "/rest/user/user.json", method = RequestMethod.DELETE)
	public String deleteFlagUser(@Valid @RequestBody UserModel userModel, ModelMap modelMap) {
		UserDomain userDomain=new UserDomain();
		userDomain.setUuid(userModel.getUuid());
		userDomain.setDeleteFlag(userModel.getDeleteFlag());
		userService.updateUser(userDomain);
		return BaseUrl.VIEW_LOC_JSON;

	}
}
