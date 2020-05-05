package com.roper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ODBCSQL.dbo.t_user_role")
@Entity
public class UserRole {
	@Id
	@Column(name = "user_id")
	public int getUse_id() {
		return use_id;
	}

	public void setUse_id(int useId) {
		use_id = useId;
	}

	@Column(name = "role_id")
	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int roleId) {
		role_id = roleId;
	}

	private int use_id;
	private int role_id;
}
