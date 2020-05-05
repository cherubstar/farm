package com.roper.controller;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Controller;

import com.roper.entity.User;
import com.roper.surface.UserSurface;
import com.roper.utils.UnicodeUtil;

@Controller
public class UserRealm extends AuthorizingRealm {
	
	/**
	 * 授权管理
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		
		/**
		 * AuthorizationInfo：
		 * 参数principals：用户名
		 */
		String username = principals.toString();
		System.out.println("用户名 : " +username);
		//String username = (String) principals.getPrimaryPrincipal();
		//
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//通过用户名获取个人信息
		User user = new UserSurface<User>(User.class).queryByUserName(username);
		//通过个人信息获取个人权限
		String permission = user.getPermission();
		//Role roles = userService.findRoles(username);
		Set<String> roleNames = new HashSet<String>();
		//roleNames.add(roles.getRoleName());
		roleNames.add(permission);
		//info.setRoles(roleNames);
		//Permission permissions = userService.findPermissions(username);
		//Set<String> permissionNames = new HashSet<String>();
		//permissionNames.add(permissions.getPermissionname());
		//info.setStringPermissions(permissionNames);
		
		//将个人权限添加到SimpleAuthorizationInfo中，让realm自己匹配权限
		info.setRoles(roleNames);
		return info;
	}

	/**
	 * 认证管理
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		SimpleAuthenticationInfo info = null;
		//将封装之后的用户登录使用的用户名和密码强转成UsernamePasswordToken
		UsernamePasswordToken UPToken = (UsernamePasswordToken) token;
		//获取用户名
		String username = UPToken.getUsername();
		//通过用户名获取个人信息,用户名通过转换成unicode格式来查询个人信息
		User user = new UserSurface<User>(User.class, username).queryByUserName();
		//判断user是否为空
		if(user != null){
			//获取用户名和密码
			String principal = user.getUsername();
			String credentials = user.getPassword();
			//将用户名和密码转换成unicode格式
			System.out.println(principal);
			System.out.println(credentials);
			principal = UnicodeUtil.decodeUnicode(principal);
			credentials = UnicodeUtil.decodeUnicode(credentials);
			System.out.println(principal);
			System.out.println(credentials);
			//将从数据库中取出来的用户名和密码进行对比
			info = new SimpleAuthenticationInfo(principal, credentials, this.getName());
		}else{
			throw new UnknownAccountException();
		}
		return info;
	}
}