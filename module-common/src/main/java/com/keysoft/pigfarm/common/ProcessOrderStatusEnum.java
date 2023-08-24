package com.keysoft.pigfarm.common;

public enum ProcessOrderStatusEnum {
	CONFIRMED("confirmed"),
	SYCNCHRONIZED("synchronized"),
	UNCONFIMRED("unconfirmed"),
//	SENT("sent"),
	CLOSED("closed");	
	
	public String status;
	private ProcessOrderStatusEnum(String status) {
		this.status = status;
	}
}
