package com.anwei.rms.repository;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.anwei.rms.pojo.domain.PermissionDomain;
import com.anwei.rms.pojo.entity.Permission;

public interface PermissionExMapper {
 
	List<PermissionDomain> selectAll(Permission permission,RowBounds rowBounds);
	List<PermissionDomain> selectAll(Permission permission);
	/**
	 * 获取下拉所有的权限
	 * @return
	 */
	List<PermissionDomain> selectCode();
}