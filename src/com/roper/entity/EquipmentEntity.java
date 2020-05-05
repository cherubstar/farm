package com.roper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ODBCSQL.dbo.Equipment")
@Entity
public class EquipmentEntity {
	
	/**
	 * 设备
	 */
	private float instantFlow1;
	private float totalFlow1;
	private float instantFlow2;
	private float totalFlow2;
	private float equipment1Temp1;
	private float equipment1Temp2;
	private float equipment2Temp1;
	private float equipment2Temp2;
	private int id;
	
	@Id
	@Column(name = "id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "instantFlow1")
	public float getInstantFlow1() {
		return instantFlow1;
	}
	public void setInstantFlow1(float instantFlow1) {
		this.instantFlow1 = instantFlow1;
	}
	
	@Column(name = "totalFlow1")
	public float getTotalFlow1() {
		return totalFlow1;
	}
	public void setTotalFlow1(float totalFlow1) {
		this.totalFlow1 = totalFlow1;
	}
	
	@Column(name = "instantFlow2")
	public float getInstantFlow2() {
		return instantFlow2;
	}
	public void setInstantFlow2(float instantFlow2) {
		this.instantFlow2 = instantFlow2;
	}
	
	@Column(name = "totalFlow2")
	public float getTotalFlow2() {
		return totalFlow2;
	}
	public void setTotalFlow2(float totalFlow2) {
		this.totalFlow2 = totalFlow2;
	}
	
	@Column(name = "equipment1Temp1")
	public float getEquipment1Temp1() {
		return equipment1Temp1;
	}
	public void setEquipment1Temp1(float equipment1Temp1) {
		this.equipment1Temp1 = equipment1Temp1;
	}
	
	@Column(name = "equipment1Temp2")
	public float getEquipment1Temp2() {
		return equipment1Temp2;
	}
	public void setEquipment1Temp2(float equipment1Temp2) {
		this.equipment1Temp2 = equipment1Temp2;
	}
	
	@Column(name = "equipment2Temp1")
	public float getEquipment2Temp1() {
		return equipment2Temp1;
	}
	public void setEquipment2Temp1(float equipment2Temp1) {
		this.equipment2Temp1 = equipment2Temp1;
	}
	
	@Column(name = "equipment2Temp2")
	public float getEquipment2Temp2() {
		return equipment2Temp2;
	}
	public void setEquipment2Temp2(float equipment2Temp2) {
		this.equipment2Temp2 = equipment2Temp2;
	}
}
