package com.anwei.rms.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anwei.rms.util.constant.BaseUrl;


@Controller
public class PermissionController {
	 @RequestMapping(value = "/permission/permission", method = RequestMethod.GET)
	 public String getQueryPermissionView() {
	    return BaseUrl.PERMISSION_VIEW;
	 }   
}
