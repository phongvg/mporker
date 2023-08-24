package com.keysoft.pigfarm.common;

public enum MaterialUnitEnum {
	KG("KG"),
	BAG("BAG")
	;
	public String val;
	private MaterialUnitEnum(String val) {
		this.val = val;
	}
}
