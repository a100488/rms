package com.anwei.rms.repository;

import com.anwei.rms.pojo.entity.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}