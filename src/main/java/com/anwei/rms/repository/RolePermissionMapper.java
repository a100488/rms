package com.anwei.rms.repository;

import com.anwei.rms.pojo.entity.RolePermission;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);
}