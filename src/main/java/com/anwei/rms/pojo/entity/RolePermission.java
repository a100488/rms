package com.anwei.rms.pojo.entity;

import java.io.Serializable;

public class RolePermission implements Serializable {
    private String uuid;

    private String roleUuid;

    private String permissionUuid;

    private static final long serialVersionUID = 1L;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getRoleUuid() {
        return roleUuid;
    }

    public void setRoleUuid(String roleUuid) {
        this.roleUuid = roleUuid == null ? null : roleUuid.trim();
    }

    public String getPermissionUuid() {
        return permissionUuid;
    }

    public void setPermissionUuid(String permissionUuid) {
        this.permissionUuid = permissionUuid == null ? null : permissionUuid.trim();
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
        RolePermission other = (RolePermission) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getRoleUuid() == null ? other.getRoleUuid() == null : this.getRoleUuid().equals(other.getRoleUuid()))
            && (this.getPermissionUuid() == null ? other.getPermissionUuid() == null : this.getPermissionUuid().equals(other.getPermissionUuid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getRoleUuid() == null) ? 0 : getRoleUuid().hashCode());
        result = prime * result + ((getPermissionUuid() == null) ? 0 : getPermissionUuid().hashCode());
        return result;
    }
}