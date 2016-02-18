
package com.anwei.rms.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.anwei.rms.pojo.domain.UserDomain;


public class SecuUtils {
	

	
	public static String getLoginId() {
		
		try {
		
		    Subject subject = SecurityUtils.getSubject();
		    Object login = subject.getPrincipal();
		    
		    if (login instanceof UserDomain) {
		    	UserDomain userDomain = (UserDomain)login;
		    	return userDomain.getUuid();
		    } else {
		    	return null;
		    }
		} catch (Exception e) {
			
			return null;
		}
	}
	
	public static String getLoginPassword() {
		
		try {
		
		    Subject subject = SecurityUtils.getSubject();
		    Object login = subject.getPrincipal();
		    
		    if (login instanceof UserDomain) {
		    	UserDomain userDomain = (UserDomain)login;
		    	return userDomain.getPassword();
		    } else {
		    	return null;
		    }
		} catch (Exception e) {
			
			return null;
		}
	}

	public static String getLoginSalt() {
		
		try {
		
		    Subject subject = SecurityUtils.getSubject();
		    Object login = subject.getPrincipal();
		    
		    if (login instanceof UserDomain) {
		    	UserDomain userDomain = (UserDomain)login;
		    	return userDomain.getSalt();
		    }else {
		    	return null;
		    }
		} catch (Exception e) {
			
			return null;
		}
	}

	

	

	
	public static boolean hasRule(String rule) {
		
	    return SecurityUtils.getSubject().hasRole(rule);
	}
}
