package com.roper.api;

import com.roper.entity.DataTableReturnObject;
import com.roper.entity.Role;

public interface UserService<T> {

	/**
	 * 查询用户规则
	 */
	Role findRoles(String username);
	
	/**
	 * 重载的方法 :　通过用户名查询
	 */
	T queryByUserName();
	T queryByUserName(String userName);
	
	/**
	 * DataTable专用接口，查询所有用户
	 */
	DataTableReturnObject findAllUser();

	/**
	 * DataTable专用接口，查询所有注册申请信息
	 */
	DataTableReturnObject findAllRegiser();

	/**
	 * 注册接口
	 */
	void regist(String username, String password, String permission,String department,String name);

	/**
	 * 注册后，审批表用户审批添加接口
	 */
	void addUser(String username);
	
	/**
	 * 注册后，审批表用户审批拒绝接口
	 */
	void refuse(String username);
	
	/**
	 * 用户删除接口
	 */
	void delete(Integer id);
}