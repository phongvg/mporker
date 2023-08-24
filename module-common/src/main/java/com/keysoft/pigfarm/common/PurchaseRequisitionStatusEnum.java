package com.keysoft.pigfarm.common;

public enum PurchaseRequisitionStatusEnum {
	CONFIRMED("confirmed"),
	UNCONFIRMED("unconfirmed"),
	REJECT("reject"),
	SYNCHRONIZED("synchronized"),
	CANCEL("cancel"),
	APPROVE("approve"),
	DELETE("delete");
	
	public String val;
	
	private PurchaseRequisitionStatusEnum(String val) {
		this.val = val;
	}
}
