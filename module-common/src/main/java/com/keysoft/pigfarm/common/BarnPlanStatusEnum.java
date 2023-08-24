package com.keysoft.pigfarm.common;

public enum BarnPlanStatusEnum {
	UNCONFIRMED ("unconfirmed"),
	CONFIRMED("confirmed"),
	SYCNCHRONIZED("synchronized");
//	SENT("sent");
	
	public String value ;
	private BarnPlanStatusEnum(String value) {
		this.value = value;
	}
}
