package com.roper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ODBCSQL.dbo.SpringGreenhouses")
@Entity
public class SpringGreenhousesEntity {

	private int id;
	private int toggle1;
	private int toggle2;
	private int toggle3;
	
	@Id
	@Column(name = "id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "toggle1")
	public int getToggle1() {
		return toggle1;
	}
	public void setToggle1(int toggle1) {
		this.toggle1 = toggle1;
	}
	
	@Column(name = "toggle2")
	public int getToggle2() {
		return toggle2;
	}
	public void setToggle2(int toggle2) {
		this.toggle2 = toggle2;
	}
	
	@Column(name = "toggle3")
	public int getToggle3() {
		return toggle3;
	}
	public void setToggle3(int toggle3) {
		this.toggle3 = toggle3;
	}
}
