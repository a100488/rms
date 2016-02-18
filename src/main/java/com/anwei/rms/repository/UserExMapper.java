package com.anwei.rms.repository;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.anwei.rms.pojo.domain.UserDomain;


public interface UserExMapper {


    List<UserDomain> selectByLoginId(String username);
    List<UserDomain> selectByPrimaryKey(UserDomain userDomain);
    List<UserDomain> selectByPrimaryKey(UserDomain userDomain,RowBounds rowBounds);
}