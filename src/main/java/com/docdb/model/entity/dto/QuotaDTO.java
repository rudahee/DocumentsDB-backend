package com.docdb.model.entity.dto;

public class QuotaDTO {
	private Long size;
	private String unit;

	public QuotaDTO() {
		super();
	}
	
	public QuotaDTO(Long size, String unit) {
		super();
		this.size = size;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
}
