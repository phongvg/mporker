package com.keysoft.pigfarm.common;

public enum MaterialTypeEnum {
	USED("1"), //duoc  su dung
	WATTING("2"), // cho xu ly
	DELETE("3"), // xoa
	;
	public String val;
	private MaterialTypeEnum(String val) {
		this.val = val;
	}
}
