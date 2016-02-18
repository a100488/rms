package com.anwei.rms.service;

import java.util.List;

import com.anwei.rms.pojo.domain.PermissionDomain;

public interface PermissionService {
	public Integer insertPermission(PermissionDomain permission);

	public Integer updatePermission(PermissionDomain permission);

	public Integer deletePermission(PermissionDomain permission);

	public List<PermissionDomain> findPermissionList(PermissionDomain permissionDomain);
	public List<PermissionDomain> selectCode();
}
