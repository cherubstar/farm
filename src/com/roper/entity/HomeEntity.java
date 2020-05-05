package com.roper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ODBCSQL.dbo.home")
@Entity
public class HomeEntity {

	private int id;
	private float outdorLight;
	private float outdorTemp;
	private float outdorHumidity;
	private float soilTemp;
	private float soilHumidity;
	private float soilPH;
	private float airPressure;
	private float pm25;
	private float windSpeed;
	private float windDirection; 
	private float rainFall;
	private String cameraUrl;
	// private float indorLight;
	
	@Id
	@Column(name = "id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "outdorLight")
	public float getOutdorLight() {
		return outdorLight;
	}
	public void setOutdorLight(float outdorLight) {
		this.outdorLight = outdorLight;
	}

	@Column(name = "outdorTemp")
	public float getOutdorTemp() {
		return outdorTemp;
	}
	public void setOutdorTemp(float outdorTemp) {
		this.outdorTemp = outdorTemp;
	}

	@Column(name = "outdorHumidity")
	public float getOutdorHumidity() {
		return outdorHumidity;
	}
	public void setOutdorHumidity(float outdorHumidity) {
		this.outdorHumidity = outdorHumidity;
	}

	// @Column(name = "indorLight")
	// public float getIndorLight() {
	// return indorLight);
	// }
	// public void setIndorLight(float indorLight) {
	// this.indorLight = indorLight;
	// }

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

	@Column(name = "soilPH")
	public float getSoilPH() {
		return soilPH;
	}
	public void setSoilPH(float soilPH) {
		this.soilPH = soilPH;
	}

	@Column(name = "airPressure")
	public float getAirPressure() {
		return airPressure;
	}
	public void setAirPressure(float airPressure) {
		this.airPressure = airPressure;
	}

	@Column(name = "pm25")
	public float getPm25() {
		return pm25;
	}
	public void setPm25(float pm25) {
		this.pm25 = pm25;
	}

	@Column(name = "windSpeed")
	public float getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(float windSpeed) {
		this.windSpeed = windSpeed;
	}

	@Column(name = "windDirection")
	public float getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(float windDirection) {
		this.windDirection = windDirection;
	}

	@Column(name = "rainFall")
	public float getRainFall() {
		return rainFall;
	}
	public void setRainFall(float rainFall) {
		this.rainFall = rainFall;
	}
	
	@Column(name="cameraUrl")
	public String getCameraUrl() {
		return cameraUrl;
	}
	public void setCameraUrl(String cameraUrl) {
		this.cameraUrl = cameraUrl;
	}
}
