package com.anwei.rms.pojo.entity;

import java.io.Serializable;

public class Permission implements Serializable {
    private String uuid;

    private String permissionName;

    private String parentUuid;

    private String orgaRelaIndex;

    private String permission;

    private Long inserTtime;

    private static final long serialVersionUID = 1L;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getParentUuid() {
        return parentUuid;
    }

    public void setParentUuid(String parentUuid) {
        this.parentUuid = parentUuid == null ? null : parentUuid.trim();
    }

    public String getOrgaRelaIndex() {
        return orgaRelaIndex;
    }

    public void setOrgaRelaIndex(String orgaRelaIndex) {
        this.orgaRelaIndex = orgaRelaIndex == null ? null : orgaRelaIndex.trim();
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public Long getInserTtime() {
        return inserTtime;
    }

    public void setInserTtime(Long inserTtime) {
        this.inserTtime = inserTtime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Permission other = (Permission) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getPermissionName() == null ? other.getPermissionName() == null : this.getPermissionName().equals(other.getPermissionName()))
            && (this.getParentUuid() == null ? other.getParentUuid() == null : this.getParentUuid().equals(other.getParentUuid()))
            && (this.getOrgaRelaIndex() == null ? other.getOrgaRelaIndex() == null : this.getOrgaRelaIndex().equals(other.getOrgaRelaIndex()))
            && (this.getPermission() == null ? other.getPermission() == null : this.getPermission().equals(other.getPermission()))
            && (this.getInserTtime() == null ? other.getInserTtime() == null : this.getInserTtime().equals(other.getInserTtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getPermissionName() == null) ? 0 : getPermissionName().hashCode());
        result = prime * result + ((getParentUuid() == null) ? 0 : getParentUuid().hashCode());
        result = prime * result + ((getOrgaRelaIndex() == null) ? 0 : getOrgaRelaIndex().hashCode());
        result = prime * result + ((getPermission() == null) ? 0 : getPermission().hashCode());
        result = prime * result + ((getInserTtime() == null) ? 0 : getInserTtime().hashCode());
        return result;
    }
}