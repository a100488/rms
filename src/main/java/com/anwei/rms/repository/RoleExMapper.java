package com.anwei.rms.repository;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.anwei.rms.pojo.domain.RoleDomain;

public interface RoleExMapper {
	public List<RoleDomain> selectAll(RoleDomain roleDomain, RowBounds rowBounds);
	public List<RoleDomain> selectAll(RoleDomain roleDomain);
	public RoleDomain selectByPrimaryKey(String uuid);
}