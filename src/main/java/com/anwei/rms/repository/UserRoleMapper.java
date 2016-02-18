package com.anwei.rms.repository;

import com.anwei.rms.pojo.entity.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}