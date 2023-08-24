package com.keysoft.pigfarm.common;

public enum EventStatusEnum {
	CONFIRMED("confirmed"),
	UNCONFIRMED("unconfirmed"),
	REJECT("reject"),
	CANCEL("cancel"),
	SYCNCHRONIZED("synchronized"),
	RECEIVED("received"),
	APPROVED("approved");


	public String val;

	private EventStatusEnum(String val) {
		this.val = val;
	}
}
