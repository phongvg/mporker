package com.keysoft.pigfarm.common;

public enum PrGroupCodeEnum {
	NBW("NBW"), //PR duoc day xuong theo tuan
	NBM("NBM");	//PR duoc day xuong theo thang
	
	public String val;
	private PrGroupCodeEnum(String val) {
		this.val = val;
	}
}
