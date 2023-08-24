package com.keysoft.pigfarm.common;

public enum StatusEnum {
	ACTIVE("active"),
	INACTIVE("inactive"),
	RECEIVED ("received"),
	CONFIRMED("confirmed"),
	UNCONFIRMED("unconfirmed"),
	REJECT("reject"),
	SEND("send"),
	APPROVE("approve");
	
	public String value;
	
	private StatusEnum(String value) {
		this.value = value;
	}
}
