package com.keysoft.pigfarm.common;

public enum MaterialDetailStatusEnum {
	WATTING("watting"),
	SYCNCHRONIZED("synchronized"),
	;
	
	public String val;
	private MaterialDetailStatusEnum(String val) {
		this.val = val;
	}
}
