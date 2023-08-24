package com.keysoft.pigfarm.common;

public enum OtherCostEnum {
	ELECTRIC("electric"),
	WATER("water");
	
	public String value;
	
	private OtherCostEnum(String value) {
		this.value = value;
	}
	public String getOtherCostEnum() {
		return value;
	}
	
}
