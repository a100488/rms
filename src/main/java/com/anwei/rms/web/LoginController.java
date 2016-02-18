package com.anwei.rms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anwei.rms.pojo.entity.User;

@Controller
public class LoginController {
	/**
	 * @return "/login"
	 */
	@RequestMapping(value = "/login")
	public String getIni0101View(HttpServletRequest request) {
		Subject subject=SecurityUtils.getSubject();
		User u=(User) subject.getPrincipal();
		if(u!=null){
			return "/success";
		}
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		HttpSession session=request.getSession();
		if (exceptionClassName != null) {
			if(UnknownAccountException.class.getName().equals(exceptionClassName)){
				session.setAttribute("loginError", "帐号不存在");
			
			}else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)){
				session.setAttribute("loginError", "帐号或密码错误");
			}else if("randCodeError".equals(exceptionClassName)){
				session.setAttribute("loginError", "验证码错误");
			}else{
				session.setAttribute("loginError", "未知错误"+exceptionClassName);
			}
			
		}
		return "/login";
	}
	
  
	@RequestMapping(value = "/index")
	public String getIndex(Model model) {
		return "/index";
	}
	@RequestMapping(value = "/noAuth")
	public String getNoAuth(){
		System.out.println("--");
		return "/noAuth";
	}
	@RequestMapping(value = "/update-password")
	public String getUpdatePassword(){
		System.out.println("--");
		return "/updatePassword";
	}
	@RequestMapping(value = "/test")
	public String test(){
		
		return "/test";
	}
}
