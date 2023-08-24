package com.keysoft.pigfarm.common;

public enum FarmTypeEnum {
	// Trại thuê
	RENT_FARM("rent_farm"),
	// Trại gia công
	MANUFACTURED_FARM("manufactured_farm");
	
	public String val;
	
	private FarmTypeEnum(String val) {
		this.val = val;
	}
}
