package com.keysoft.pigfarm.common;

public enum PigType {
	HAI_MAU ("hai_mau"),
	BA_MAU("ba_mau"),
	HAU_BI ("hau_bi"),
	NAI ("nai"),
	TINH ("tinh"),
	CHOAI ("choai");
	
	
	public String value;
	private PigType(String value) {
		this.value = value;
	}
	public String getPigType() {
		return value;
	}
}
