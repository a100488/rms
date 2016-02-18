package com.anwei.rms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anwei.rms.exception.BusinessServerErrorException;
import com.anwei.rms.pojo.domain.RoleDomain;
import com.anwei.rms.pojo.entity.Role;
import com.anwei.rms.pojo.entity.RolePermission;
import com.anwei.rms.pojo.model.PagingCondition;
import com.anwei.rms.repository.RoleExMapper;
import com.anwei.rms.repository.RoleMapper;
import com.anwei.rms.repository.RolePermissionExMapper;
import com.anwei.rms.repository.RolePermissionMapper;
import com.anwei.rms.service.RoleService;
import com.anwei.rms.util.StringUtils;
import com.anwei.rms.util.UuidUtils;
import com.anwei.rms.util.constant.CodeConstant;
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	RoleMapper roleMapper;
	@Autowired
	RoleExMapper roleExMapper;
	@Autowired
	RolePermissionMapper rolePermissionMapper;
	@Autowired
	RolePermissionExMapper rolePermissionExMapper;
	@Override
	@Transactional
	public Integer saveRole(RoleDomain roleDomain) {
		RoleDomain r=new RoleDomain();
		r.setRoleName(roleDomain.getRoleName());
		List<RoleDomain> list=roleExMapper.selectAll(r);
		if(list!=null&&list.size()>0){
			throw new BusinessServerErrorException("角色名称不能重复。");
		}
		Role role=new Role();
		String roleUuid = UuidUtils.base58Uuid();
		//Long system=System.currentTimeMillis();
		role.setUuid(roleUuid);
		role.setRoleName(roleDomain.getRoleName());
		role.setMemo(roleDomain.getMemo());
		role.setDeleteFlag(CodeConstant.CODE_CONSTANT_DELETEFLAG_0);
		 roleMapper.insert(role);
		 //添加权限
		 if(roleDomain.getPermissionIds()!=null&&roleDomain.getPermissionIds().length>0){
			 String[] permissionIds=roleDomain.getPermissionIds();
			 for(int i=0;i<permissionIds.length;i++){
			 RolePermission rolePermission=new RolePermission();
			 String rolePermissionUuid = UuidUtils.base58Uuid();
			 rolePermission.setUuid(rolePermissionUuid);
			 rolePermission.setRoleUuid(roleUuid);
			 rolePermission.setPermissionUuid(permissionIds[i]);
			 rolePermissionMapper.insert(rolePermission);
			 }
			
		 }
		 
		 return 1;
	}

	@Override
	public Integer deleteRole(RoleDomain role) {
		Role r=roleMapper.selectByPrimaryKey(role.getUuid());
		if(r==null){
			throw new BusinessServerErrorException("找不到该对象");
		}
		return roleMapper.deleteByPrimaryKey(role.getUuid());
	}

	@Override
	public List<RoleDomain> findRoleList(RoleDomain role) {
		return roleExMapper.selectAll(role);
	}

	@Override
	@Transactional
	public Integer updateRole(RoleDomain roleDomain) {
		
		RoleDomain role=roleExMapper.selectByPrimaryKey(roleDomain.getUuid());
		if(role==null){
			throw new BusinessServerErrorException("找不到该对象");
		}
		if(StringUtils.isNotBlank(roleDomain.getRoleName())){
			role.setRoleName(roleDomain.getRoleName());
		}
		if(StringUtils.isNotEmpty(roleDomain.getMemo())){
			role.setMemo(roleDomain.getMemo());
		}
		if(StringUtils.isNotBlank(roleDomain.getDeleteFlag())){
			role.setDeleteFlag(roleDomain.getDeleteFlag());
		}
		roleMapper.updateByPrimaryKey(role);
		 //修改角色权限表
			 if(roleDomain.getPermissionIds()!=null&&roleDomain.getPermissionIds().length>0){
				//删除所有
				rolePermissionExMapper.deleteRolePermission(role.getUuid());
				 String[] permissionIds=roleDomain.getPermissionIds();
				 for(int i=0;i<permissionIds.length;i++){
				 RolePermission rolePermission=new RolePermission();
				 String rolePermissionUuid = UuidUtils.base58Uuid();
				 rolePermission.setUuid(rolePermissionUuid);
				 rolePermission.setRoleUuid(role.getUuid());
				 rolePermission.setPermissionUuid(permissionIds[i]);
				 rolePermissionMapper.insert(rolePermission);
				 }
				
			 }
		 
		 return 1;
	}

	@Override
	public List<RoleDomain> findRoleList(PagingCondition<RoleDomain> condition) {
		RoleDomain searchObject = condition.getSearchObject();
		List<RoleDomain> list = roleExMapper.selectAll(searchObject, condition.getRowBounds());
		condition.total(list);
		return list;
	}

	

}
