package com.anwei.rms.service;

import java.util.List;

import com.anwei.rms.pojo.domain.UserDomain;
import com.anwei.rms.pojo.entity.User;
import com.anwei.rms.pojo.model.PagingCondition;


public interface UserService {
	/**
	 * 根据用户名查询
	 * @param userName
	 * @return
	 */
	public List<UserDomain> getLoginInfo(String userName);
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public Integer insertUser(UserDomain user);
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	public Integer updateUser(UserDomain user);
	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	public Integer deleteUser(UserDomain user);
	/**
	 * 根据id查找
	 * @param uuid
	 * @return
	 */
	public User findById(String uuid);
	/**
	 * 修改密码
	 * @param user
	 * @return
	 */
	Integer updatePassword(UserDomain user);
	List<UserDomain> selectUserList(PagingCondition<UserDomain> pagingCondition);
}
