package com.roper.entity;

public class DataTableReturnObject {
	
	private int draw;
	private int recordsTota;
	private int recordsFiltered;
	private String data;
	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getRecordsTota() {
		return recordsTota;
	}

	public void setRecordsTota(int recordsTota) {
		this.recordsTota = recordsTota;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}