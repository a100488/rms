package com.anwei.rms.web.rest;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.anwei.rms.pojo.domain.RoleDomain;
import com.anwei.rms.pojo.model.PagingCondition;
import com.anwei.rms.pojo.model.role.RoleModel;
import com.anwei.rms.service.RoleService;
import com.anwei.rms.util.constant.BaseUrl;
import com.anwei.rms.util.constant.CodeConstant;
import com.anwei.rms.util.constant.ConditionConstant;

@Controller
public class RestRoleController {
	@Autowired
	RoleService roleService;
	@RequestMapping(value = "/rest/role/role-list.json", method = RequestMethod.GET)
	public String getRoleList(@RequestParam Map<String, String> params, ModelMap modelMap) throws ParseException {
		RoleDomain searchDomain=new RoleDomain();
		PagingCondition<RoleDomain> condition = new PagingCondition<RoleDomain>(
				params, searchDomain);
		if (condition.hasFilter()) {
			searchDomain.setRoleName(condition.getFilter());
		}
		searchDomain.setDeleteFlag(params.get(ConditionConstant.CONDITION_DELETEFLAG));
		RoleModel roleModel = new RoleModel();
		roleModel.setData(roleService.findRoleList(condition));
		roleModel.setCondition(condition);
		modelMap.addAttribute(roleModel);
		return BaseUrl.VIEW_LOC_JSON;
	}
	@RequestMapping(value = "/rest/role/role.json", method = RequestMethod.POST)
	@RequiresPermissions("addRole")
	public String saveRole(@Valid @RequestBody RoleModel roleModel, ModelMap modelMap) {
		RoleDomain roleDomain=new RoleDomain();
		roleDomain.setRoleName(roleModel.getRoleName());
		roleDomain.setMemo(roleModel.getMemo());
		roleDomain.setPermissionIds(roleModel.getPermissionIds());
		roleDomain.setDeleteFlag(CodeConstant.CODE_CONSTANT_DELETEFLAG_0);
		roleService.saveRole(roleDomain);
		return BaseUrl.VIEW_LOC_JSON;

	}
	@RequiresPermissions("editRole")
	@RequestMapping(value = "/rest/role/role.json", method = RequestMethod.PUT)
	public String updateRole(@Valid @RequestBody RoleModel roleModel, ModelMap modelMap) {
		RoleDomain roleDomain=new RoleDomain();
		roleDomain.setUuid(roleModel.getUuid());
		roleDomain.setRoleName(roleModel.getRoleName());
		roleDomain.setMemo(roleModel.getMemo());
		roleDomain.setPermissionIds(roleModel.getPermissionIds());
		roleService.updateRole(roleDomain);
		return BaseUrl.VIEW_LOC_JSON;

	}
	@RequiresPermissions("isDisableRole")
	@RequestMapping(value = "/rest/role/role.json", method = RequestMethod.DELETE)
	public String deleteFlagRole(@Valid @RequestBody RoleModel roleModel, ModelMap modelMap) {
		RoleDomain roleDomain=new RoleDomain();
		roleDomain.setUuid(roleModel.getUuid());
		roleDomain.setDeleteFlag(roleModel.getDeleteFlag());
		roleService.updateRole(roleDomain);
		return BaseUrl.VIEW_LOC_JSON;

	}
	@RequestMapping(value = "/rest/role/role-select_code.json", method = RequestMethod.GET)
	public String roleList(@RequestParam Map<String, String> params,HttpServletRequest request, ModelMap modelMap) throws ParseException {
		RoleDomain roleDomain=new RoleDomain();
		roleDomain.setDeleteFlag(CodeConstant.CODE_CONSTANT_DELETEFLAG_0);
		List<RoleDomain> list = roleService.findRoleList(roleDomain);
		modelMap.addAttribute(list);
		return BaseUrl.VIEW_LOC_JSON;
	}
}
