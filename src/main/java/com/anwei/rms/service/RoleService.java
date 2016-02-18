package com.anwei.rms.service;

import java.util.List;

import com.anwei.rms.pojo.domain.RoleDomain;
import com.anwei.rms.pojo.model.PagingCondition;

public interface RoleService {
	public Integer updateRole(RoleDomain role);
	public Integer saveRole(RoleDomain role);
	public Integer deleteRole(RoleDomain role);
	public List<RoleDomain> findRoleList(PagingCondition<RoleDomain> condition);
	public List<RoleDomain> findRoleList(RoleDomain roleDomain);
}
