package com.anwei.rms.pojo.model.role;

import java.io.Serializable;

import com.anwei.rms.pojo.domain.RoleDomain;
import com.anwei.rms.pojo.model.PagingModel;

public class RoleModel extends PagingModel<RoleDomain>implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2705574739562807150L;
	private String uuid;
	private String roleName;
	private String memo;
	private String deleteFlag;
	private String[] permissionIds;
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String[] getPermissionIds() {
		return permissionIds;
	}

	public void setPermissionIds(String[] permissionIds) {
		this.permissionIds = permissionIds;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	
	
}
