package com.roper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ODBCSQL.dbo.Light")
@Entity
public class LightEntity {
	
	private int id;
	private int toggle;
	private float indorCo2;
	private float indorHumidity;
	private float indorTemp;
	private float indorLight;
	private float soilTemp;
	private float soilHumidity;
	private String cameraUrl;
	private String cameraUrl2;
	
	@Id
	@Column(name = "id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "toggle")
	public int getToggle() {
		return toggle;
	}
	public void setToggle(int toggle) {
		this.toggle = toggle;
	}

	@Column(name = "indorHumidity")
	public float getIndorHumidity() {
		return indorHumidity;
	}
	public void setIndorHumidity(float indorHumidity) {
		this.indorHumidity = indorHumidity;
	}

	@Column(name = "indorTemp")
	public float getIndorTemp() {
		return indorTemp;
	}
	public void setIndorTemp(float indorTemp) {
		this.indorTemp = indorTemp;
	}
	
	@Column(name = "indorLight")
	public float getIndorLight() {
		return indorLight;
	}
	public void setIndorLight(float indorLight) {
		this.indorLight = indorLight;
	}

	@Column(name = "soilTemp")
	public float getSoilTemp() {
		return soilTemp;
	}
	public void setSoilTemp(float soilTemp) {
		this.soilTemp = soilTemp;
	}

	@Column(name = "soilHumidity")
	public float getSoilHumidity() {
		return soilHumidity;
	}
	public void setSoilHumidity(float soilHumidity) {
		this.soilHumidity = soilHumidity;
	}
	
	@Column(name = "indorCo2")
	public float getIndorCo2() {
		return indorCo2;
	}
	public void setIndorCo2(float indorCo2) {
		this.indorCo2 = indorCo2;
	}
	
	@Column(name = "cameraUrl")
	public String getCameraUrl() {
		return cameraUrl;
	}
	public void setCameraUrl(String cameraUrl) {
		this.cameraUrl = cameraUrl;
	}
	
	@Column(name = "cameraUrl2")
	public String getCameraUrl2() {
		return cameraUrl2;
	}
	public void setCameraUrl2(String cameraUrl2) {
		this.cameraUrl2 = cameraUrl2;
	}
}

