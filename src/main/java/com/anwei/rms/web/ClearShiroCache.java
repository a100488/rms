package com.anwei.rms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anwei.rms.common.auth.CustomRealm;
@Controller
public class ClearShiroCache {
	@Autowired
	CustomRealm customRealm;

	@RequestMapping("/clearShiroCache")
	public String clearShiroCache() {
		customRealm.clearCache();
		return "success";
	}
}
