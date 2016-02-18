package com.anwei.rms.pojo.domain;


import java.util.List;

import org.springframework.beans.BeanUtils;

import com.anwei.rms.pojo.entity.Role;
import com.anwei.rms.pojo.entity.RolePermission;

public class RoleDomain extends Role {
	private List<RolePermission> rolePermissionList;
	public RoleDomain(Role role) {
		if(role!=null){
		BeanUtils.copyProperties(role, this);
		}
	}
	private String[] permissionIds;
	public RoleDomain() {
		super();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -5423889603485805650L;
	
	public List<RolePermission> getRolePermissionList() {
		return rolePermissionList;
	}
	public void setRolePermissionList(List<RolePermission> rolePermissionList) {
		this.rolePermissionList = rolePermissionList;
	}
	public String[] getPermissionIds() {
		return permissionIds;
	}
	public void setPermissionIds(String[] permissionIds) {
		this.permissionIds = permissionIds;
	}

}
