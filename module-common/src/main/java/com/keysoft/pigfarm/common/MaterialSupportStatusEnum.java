package com.keysoft.pigfarm.common;

public enum MaterialSupportStatusEnum {
	ENABLED("enabled"), 
	DISABLED("disabled"),
	;
	public String val;
	private MaterialSupportStatusEnum(String val) {
		this.val = val;
	}
}
