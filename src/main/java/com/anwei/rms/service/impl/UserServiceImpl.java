package com.anwei.rms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anwei.rms.pojo.domain.UserDomain;
import com.anwei.rms.pojo.entity.User;
import com.anwei.rms.pojo.entity.UserRole;
import com.anwei.rms.pojo.model.PagingCondition;
import com.anwei.rms.repository.UserExMapper;
import com.anwei.rms.repository.UserMapper;
import com.anwei.rms.repository.UserRoleExMapper;
import com.anwei.rms.repository.UserRoleMapper;
import com.anwei.rms.service.UserService;
import com.anwei.rms.util.DigestUtils;
import com.anwei.rms.util.EncodeUtils;
import com.anwei.rms.util.MyUtils;
import com.anwei.rms.util.StringUtils;
import com.anwei.rms.util.UuidUtils;
import com.anwei.rms.util.constant.CodeConstant;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserExMapper userExMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	UserRoleMapper userRoleMapper;
	@Autowired
	UserRoleExMapper userRoleExMapper;
	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(User login, String password) {
		byte[] salt = DigestUtils.generateSalt(Integer.parseInt(CodeConstant.SALT_SIZE));
		String saltStr=EncodeUtils.encodeHex(salt);
		login.setSalt(saltStr);
		String passwordStr=	MyUtils.getPasswordShaCode(password,saltStr);
		login.setPassword(passwordStr);
	}
	
	@Override
	public List<UserDomain> getLoginInfo(String userName) {
		
		return userExMapper.selectByLoginId(userName);
	}
	@Override
	@Transactional
	public Integer insertUser(UserDomain userDomain) {
		List<UserDomain> list=userExMapper.selectByLoginId(userDomain.getUserName());
		if(list.size()>0){
			throw new RuntimeException("用户名称不能重复");
		}
		User user=new User();
		String uuid = UuidUtils.base58Uuid();
		user.setUuid(uuid);
		user.setUserName(userDomain.getUserName());
		user.setDeleteFlag(userDomain.getDeleteFlag());
		user.setName(userDomain.getName());
		entryptPassword(user,userDomain.getPassword());
		userMapper.insert(user);
		if(userDomain.getRoleIds()!=null&&userDomain.getRoleIds().length>0){
			String[] roleIds=userDomain.getRoleIds();
			for(int i=0;i<roleIds.length;i++){
				String urUuid=UuidUtils.base58Uuid();
				UserRole ur=new UserRole();
				ur.setUserUuid(uuid);
				ur.setRoleUuid(roleIds[i]);
				ur.setUuid(urUuid);
				userRoleMapper.insert(ur);
			}
		}
		return 1;
	}
	@Override
	@Transactional
	public Integer updateUser(UserDomain userDomain) {
		User user=userMapper.selectByPrimaryKey(userDomain.getUuid());
		if(user==null){
			throw new RuntimeException("找不到对象");
		}
		if(StringUtils.isNotBlank(userDomain.getUserName())){
		user.setUserName(userDomain.getUserName());
		}
		if(StringUtils.isNotBlank(userDomain.getUserName())){
			user.setName(userDomain.getName());
		}
		if(StringUtils.isNotBlank(userDomain.getDeleteFlag())){
			user.setDeleteFlag(userDomain.getDeleteFlag());
		}
		userMapper.updateByPrimaryKey(user);
		if(userDomain.getRoleIds()!=null&&userDomain.getRoleIds().length>0){
			userRoleExMapper.deleteByUserRole(user.getUuid());
			String[] roleIds=userDomain.getRoleIds();
			for(int i=0;i<roleIds.length;i++){
				String urUuid=UuidUtils.base58Uuid();
				UserRole ur=new UserRole();
				ur.setUserUuid(user.getUuid());
				ur.setRoleUuid(roleIds[i]);
				ur.setUuid(urUuid);
				userRoleMapper.insert(ur);
			}
		}
		return 1;
		
	}
	@Override
	@Transactional
	public Integer deleteUser(UserDomain userDomain) {
		User user=userMapper.selectByPrimaryKey(userDomain.getUuid());
		if(user==null){
			throw new RuntimeException("找不到对象");
		}
		
		return userMapper.deleteByPrimaryKey(userDomain.getUuid());
	}
	@Override
	public User findById(String uuid) {
		User user=userMapper.selectByPrimaryKey(uuid);
		return user;
	}
	@Override
	@Transactional
	public Integer updatePassword(UserDomain userDomain) {
		if(userDomain.getOldPassowrd().equals(userDomain.getPassword())){
			throw new RuntimeException("新密码与旧密码不能相同");
		}
		User user=userMapper.selectByPrimaryKey(userDomain.getUuid());
		if(user.getPassword().equals(MyUtils.getPasswordShaCode(userDomain.getOldPassowrd(), user.getSalt()))){
			throw new RuntimeException("输入的旧密码不正确");
		}
		this.entryptPassword(user, userDomain.getPassword());
		
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public List<UserDomain> selectUserList(PagingCondition<UserDomain> pagingCondition) {
		
		return userExMapper.selectByPrimaryKey(pagingCondition.getSearchObject(),pagingCondition.getRowBounds());
	}
	

}
