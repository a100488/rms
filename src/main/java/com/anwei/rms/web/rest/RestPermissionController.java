package com.anwei.rms.web.rest;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.anwei.rms.pojo.domain.PermissionDomain;
import com.anwei.rms.pojo.model.permission.PermissionModel;
import com.anwei.rms.service.PermissionService;
import com.anwei.rms.util.MessageUtils;
import com.anwei.rms.util.StringUtils;
import com.anwei.rms.util.constant.BaseUrl;
import com.anwei.rms.util.constant.CodeConstant;
import com.anwei.rms.util.constant.MessageConstant;

@Controller
public class RestPermissionController {
	@Autowired
	PermissionService permissionService;
	@RequestMapping(value = "/rest/permission/permission.json", method = RequestMethod.GET)
	public String getPermission(@RequestParam Map<String, String> params,HttpServletRequest request, ModelMap modelMap) throws ParseException {
		PermissionDomain permissionDomain = new PermissionDomain();
		List<PermissionDomain> list = permissionService.findPermissionList(permissionDomain);
		PermissionModel queryPermission = new PermissionModel();
		Locale locale=(Locale) request.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
		queryPermission.setPermissionName(MessageUtils.getMessage(locale,MessageConstant.SYSTEM_NAME));
		queryPermission.setData(list);
		modelMap.addAttribute(queryPermission);
		return BaseUrl.VIEW_LOC_JSON;
	}
	@RequestMapping(value = "/rest/permission/permission-select_code.json", method = RequestMethod.GET)
	public String permissionList(@RequestParam Map<String, String> params,HttpServletRequest request, ModelMap modelMap) throws ParseException {
		List<PermissionDomain> list = permissionService.selectCode();
		modelMap.addAttribute(list);
		return BaseUrl.VIEW_LOC_JSON;
	}
	@RequiresPermissions("addPermission")
	@RequestMapping(value = "/rest/permission/permission.json", method = RequestMethod.POST)
	public String savePermission(@Valid @RequestBody PermissionModel permissionModel,
			 BindingResult bindingResult, ModelMap modelMap) {
		if (bindingResult.hasErrors()) {
			throw new RuntimeException("验证失败!");
		}
		PermissionDomain permissionDomain = new PermissionDomain();
		permissionDomain.setParentUuid(permissionModel.getParentUuid());
		permissionDomain.setPermissionName(permissionModel.getPermissionName());
		permissionDomain.setPermission(permissionModel.getPermission());
		permissionService.insertPermission(permissionDomain);
		return BaseUrl.VIEW_LOC_JSON;

	}
	@RequiresPermissions("updatePermission")
	@RequestMapping(value = "/rest/permission/permission.json", method = RequestMethod.PUT)
	public String updatePermission(@Valid @RequestBody PermissionModel permissionModel,
			 BindingResult bindingResult, ModelMap modelMap) {
		if (bindingResult.hasErrors()) {
			throw new RuntimeException("验证失败!");
		}
		PermissionDomain permissionDomain = new PermissionDomain();
		permissionDomain.setUuid(permissionModel.getUuid());;
		permissionDomain.setPermissionName(permissionModel.getPermissionName());
		permissionDomain.setPermission(permissionModel.getPermission());
		permissionService.updatePermission(permissionDomain);
		return BaseUrl.VIEW_LOC_JSON;

	}
	@RequiresPermissions("deletePermission")
	@RequestMapping(value = "/rest/permission/permission.json", method = RequestMethod.DELETE)
	public String deletePermission(@Valid @RequestBody PermissionModel permissionModel,
			 BindingResult bindingResult, ModelMap modelMap) {
		if (bindingResult.hasErrors()) {
			throw new RuntimeException("验证失败!");
		}
		PermissionDomain permissionDomain = new PermissionDomain();
		permissionDomain.setUuid(permissionModel.getUuid());;
		permissionService.updatePermission(permissionDomain);
		return BaseUrl.VIEW_LOC_JSON;

	}
	@RequestMapping(value = "/rest/permission/permissionValid/{validCode}.json", method = RequestMethod.POST)
	public String permissionValid(@PathVariable String validCode, ModelMap modelMap) {
		if(StringUtils.isNotBlank(validCode)&&validCode.equals(CodeConstant.SYSTEM_PASSWORD)){
			modelMap.put("valid", true);
		}else{
			throw new RuntimeException("验证失败!");
		}
		return BaseUrl.VIEW_LOC_JSON;

	}
}
