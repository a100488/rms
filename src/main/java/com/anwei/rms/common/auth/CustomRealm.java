package com.anwei.rms.common.auth;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.anwei.rms.pojo.domain.UserDomain;
import com.anwei.rms.pojo.entity.Permission;
import com.anwei.rms.service.UserService;
import com.anwei.rms.util.constant.CodeConstant;

public class CustomRealm extends AuthorizingRealm {
	@Autowired
	UserService userService;

	// 用于认证
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName("customRealm");
	}
	
	public CustomRealm(){
		HashedCredentialsMatcher credentialsMatcher=new HashedCredentialsMatcher();
		credentialsMatcher.setHashAlgorithmName(CodeConstant.HASH_ALGORITHM);
		credentialsMatcher.setHashIterations(Integer.parseInt(CodeConstant.HASH_INTERATIONS));
		this.setCredentialsMatcher(credentialsMatcher);
	}
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		if (token.getUsername() == null) {
			return null;
		}
		// 第一步 从token里取出身份信息
		String userCode = (String) token.getUsername();
		// 第二部:根据用户输入的userCode从数据库查询
		List<UserDomain> userList = userService.getLoginInfo(userCode);
		if (!CollectionUtils.isEmpty(userList)) {
			UserDomain loginInfo = userList.get(0);
			return new SimpleAuthenticationInfo(loginInfo, loginInfo.getPassword(),ByteSource.Util.bytes(loginInfo.getSalt()), getName());

		} else {
			throw new UnknownAccountException();
		}

	}
	
	public void clearCache() {
		PrincipalCollection principals=SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}

	// 用于授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		//从principals获取主身份信息
		//将getPrimaryPrincipal方法返回转为真实身份类型
		UserDomain u= (UserDomain) principalCollection.getPrimaryPrincipal();
		//根据身份信息获取权限信息
		List<Permission> list= u.getUserPermissionList();
		//连接数据库。。。
		//模拟从数据库获取到数据
		List<String> permissions=new ArrayList<String>();
		if(list!=null&&list.size()>0){
			for(Permission p:list){
				permissions.add(p.getPermission());
			}
		}
		
		//查到权限数据，返回授权信息
		SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addStringPermissions(permissions);
		return simpleAuthorizationInfo;
	}

}
