package com.anwei.rms.pojo.domain;

import java.io.Serializable;
import java.util.List;

import com.anwei.rms.pojo.entity.Permission;
import com.anwei.rms.pojo.entity.Role;
import com.anwei.rms.pojo.entity.User;
import com.anwei.rms.util.SecuUtils;

public class UserDomain extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1656856035843343179L;
	private String oldPassowrd;
	private String[] roleIds;
	private List<Role> userRoleList;
	private List<Permission> userPermissionList;
	public String getOldPassowrd() {
		return oldPassowrd;
	}
	public void setOldPassowrd(String oldPassowrd) {
		this.oldPassowrd = oldPassowrd;
	}
	public boolean getIsLoginUser() {
		return SecuUtils.getLoginId().equals(super.getUuid());
	}
	public String[] getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}
	public List<Role> getUserRoleList() {
		return userRoleList;
	}
	public void setUserRoleList(List<Role> userRoleList) {
		this.userRoleList = userRoleList;
	}
	public List<Permission> getUserPermissionList() {
		return userPermissionList;
	}
	public void setUserPermissionList(List<Permission> userPermissionList) {
		this.userPermissionList = userPermissionList;
	}
}