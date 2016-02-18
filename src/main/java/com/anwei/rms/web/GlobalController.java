package com.anwei.rms.web;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@Controller
public class GlobalController {
    
	   @RequestMapping(value="/global-login", method = {RequestMethod.GET})
	    public String globalLogin(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(value="langType", defaultValue="zh") String langType){
	      
	            
	            if(langType.equals("zh")){
	                Locale locale = new Locale("zh", "CN"); 
	                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale); 
	            }
	            else if(langType.equals("en")){
	                Locale locale = new Locale("en", "US"); 
	                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
	            }
	            else 
	                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,LocaleContextHolder.getLocale());
	            
	        	return "/login";
	    }
	   @RequestMapping(value="/global-index", method = {RequestMethod.GET})
	    public String globalIndex(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(value="langType", defaultValue="zh") String langType){
	      
	            
	            if(langType.equals("zh")){
	                Locale locale = new Locale("zh", "CN"); 
	                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale); 
	            }
	            else if(langType.equals("en")){
	                Locale locale = new Locale("en", "US"); 
	                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
	            }
	            else 
	                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,LocaleContextHolder.getLocale());
	            
	        	return "/index";
	    }
}