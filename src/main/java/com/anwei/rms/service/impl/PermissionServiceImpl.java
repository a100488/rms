package com.anwei.rms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anwei.rms.exception.BusinessServerErrorException;
import com.anwei.rms.pojo.domain.PermissionDomain;
import com.anwei.rms.pojo.entity.Permission;
import com.anwei.rms.repository.PermissionExMapper;
import com.anwei.rms.repository.PermissionMapper;
import com.anwei.rms.service.PermissionService;
import com.anwei.rms.util.MessageUtils;
import com.anwei.rms.util.UuidUtils;
import com.anwei.rms.util.constant.MessageConstant;

@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	PermissionMapper permissionMapper;
	@Autowired
	PermissionExMapper permissionExMapper;

	@Override
	@Transactional
	public Integer insertPermission(PermissionDomain permissionDomain) {
		PermissionDomain p =new PermissionDomain();
		p.setPermission(permissionDomain.getPermission());
		List<PermissionDomain> list= permissionExMapper.selectAll(p);
		if(list!=null&&list.size()>0){
			throw new BusinessServerErrorException(MessageUtils.getMessage(MessageConstant.MSG_CODE_ERROR_PERMISSION_001));
		}
		
		
		Permission permission = new Permission();
		permission.setPermission(permissionDomain.getPermission());
		permission.setPermissionName(permissionDomain.getPermissionName());
		String uuid = UuidUtils.base58Uuid();
		Long system=System.currentTimeMillis();
		permission.setInserTtime(system);
		permission.setUuid(uuid);
		// 有父级
		if (permissionDomain.getParentUuid() != null && !permissionDomain.getParentUuid().equals("")
				&& !permissionDomain.getParentUuid().equals("0")) {
			Permission parentPermission = permissionMapper.selectByPrimaryKey(permissionDomain.getParentUuid());
			if(parentPermission==null){
				throw new NullPointerException("查询不到数据");
			}
			permission.setParentUuid(parentPermission.getUuid());
			permission.setOrgaRelaIndex(parentPermission.getOrgaRelaIndex() + uuid);
		}else{
			//没有父级
			permission.setOrgaRelaIndex(uuid);
		}
		return permissionMapper.insert(permission);
	}

	@Override
	@Transactional
	public Integer updatePermission(PermissionDomain permissionDomain) {
		Permission permission = permissionMapper.selectByPrimaryKey(permissionDomain.getUuid());
		if (permission == null) {
			throw new BusinessServerErrorException("找不到对象");
		}
		permission.setPermission(permissionDomain.getPermission());
		permission.setPermissionName(permissionDomain.getPermissionName());
		
		PermissionDomain p =new PermissionDomain();
		p.setPermission(permissionDomain.getPermission());
		List<PermissionDomain> list= permissionExMapper.selectAll(p);
		if(list!=null&&list.size()>0&&!list.get(0).getUuid().equals(permission.getUuid())){
			throw new BusinessServerErrorException("权限代码不能重复。");
		}
		return permissionMapper.updateByPrimaryKeySelective(permission);
	}

	@Override
	@Transactional
	public Integer deletePermission(PermissionDomain permissionDomain) {
		Permission permission = permissionMapper.selectByPrimaryKey(permissionDomain.getUuid());
		if (permission == null) {
			throw new BusinessServerErrorException("找不到对象");
		}
		PermissionDomain p =new PermissionDomain();
		p.setParentUuid(permissionDomain.getUuid());
		List<PermissionDomain> list= permissionExMapper.selectAll(p);
		if(list!=null&&list.size()>0){
			throw new BusinessServerErrorException("该功能有下级权限,不能删除");
		}
		return permissionMapper.deleteByPrimaryKey(permission.getUuid());
	}

	@Override
	public List<PermissionDomain> findPermissionList(PermissionDomain condition) {
		List<PermissionDomain> list = permissionExMapper.selectAll(condition);
		return list;
	}

	@Override
	public List<PermissionDomain> selectCode() {
		
		return permissionExMapper.selectCode();
	}

}
