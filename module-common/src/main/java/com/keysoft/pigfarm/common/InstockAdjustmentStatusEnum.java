package com.keysoft.pigfarm.common;

public enum InstockAdjustmentStatusEnum {
	CONFIRMED("confirmed"),
	CANCEL("cancel"),
	SYCNCHRONIZED("synchronized"),
	;


	public String val;

	private InstockAdjustmentStatusEnum(String val) {
		this.val = val;
	}
}
