package com.anwei.rms.pojo.model.permission;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.anwei.rms.pojo.domain.PermissionDomain;
import com.anwei.rms.pojo.model.PagingModel;

public class PermissionModel extends PagingModel<PermissionDomain> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5952503387671074600L;
	  // Id
	/*    @NotBlank*/
	    @Length(max=22)
	    private String uuid;

	    
	    @NotBlank
	    @Length(max=50)
	    private String permissionName;

	    private String parentUuid;

	    private String orgaRelaIndex;
	    @NotBlank
	    @Length(max=225)
	    private String permission;
		public String getUuid() {
			return uuid;
		}
		public void setUuid(String uuid) {
			this.uuid = uuid;
		}
		public String getPermissionName() {
			return permissionName;
		}
		public void setPermissionName(String permissionName) {
			this.permissionName = permissionName;
		}
		public String getParentUuid() {
			return parentUuid;
		}
		public void setParentUuid(String parentUuid) {
			this.parentUuid = parentUuid;
		}
		public String getOrgaRelaIndex() {
			return orgaRelaIndex;
		}
		public void setOrgaRelaIndex(String orgaRelaIndex) {
			this.orgaRelaIndex = orgaRelaIndex;
		}
		public String getPermission() {
			return permission;
		}
		public void setPermission(String permission) {
			this.permission = permission;
		}

}
