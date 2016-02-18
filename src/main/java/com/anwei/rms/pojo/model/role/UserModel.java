package com.anwei.rms.pojo.model.role;

import java.io.Serializable;

import com.anwei.rms.pojo.domain.UserDomain;
import com.anwei.rms.pojo.model.PagingModel;

public class UserModel extends PagingModel<UserDomain>implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4595891593572398689L;
	private String uuid;

	private String userName;

	private String password;

	private String deleteFlag;

	private String name;
	private String oldPassowrd;
	private String[] roleIds;
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOldPassowrd() {
		return oldPassowrd;
	}

	public void setOldPassowrd(String oldPassowrd) {
		this.oldPassowrd = oldPassowrd;
	}

	public String[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}

}
