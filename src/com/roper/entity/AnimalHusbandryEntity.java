package com.roper.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class AnimalHusbandryEntity {

	/**
	 * 畜牧业
	 */
	private int id;
	
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
