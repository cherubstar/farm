package com.roper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_location")
public class LocationEntity {
	
	private String id;
	private String timestamp;
	private String lat;
	private String lon;
	
	@Id
	@Column(name="id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@Column(name="timestamp")
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	@Column(name="lat")
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	
	@Column(name="lon")
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}

	@Override
	public String toString() {
		return "LocationEntity [id=" + id + ", lat=" + lat + ", lon=" + lon
				+ ", timestamp=" + timestamp + "]";
	}
}
