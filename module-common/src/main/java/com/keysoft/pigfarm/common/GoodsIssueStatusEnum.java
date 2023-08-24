package com.keysoft.pigfarm.common;

public enum GoodsIssueStatusEnum {
	CONFIRMED("confirmed"),
	CANCEL("cancel"),
	UNCONFIRMED("unconfirmed"),
	REJECT("reject"),
	SYCNCHRONIZED("synchronized"),
	RECEIVED("received"),
	APPROVE("approve");


	public String val;

	private GoodsIssueStatusEnum(String val) {
		this.val = val;
	}
}
