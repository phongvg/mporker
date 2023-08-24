package com.keysoft.pigfarm.common;

public enum TransCodeTypeEnum {
	PURCHASE_REQUISITION("PURCHASE_REQUISITION"),
	GOODS_RECEIPT("GOODS_RECEIPT"),
	GOODS_ISSUE("GOODS_ISSUE"),
	EVENT("EVENT"),
	GOODS_ATTRITION("GOODS_ATTRITION"),
	ORTHER_COST("ORTHER_COST"),
	PROPOSAL("PROPOSAL"),
	PIG_ENTRY("PIG_ENTRY"),
	INSTOCK_ADJUSTMENT("INSTOCK_ADJUSTMENT");
	
	public String val;
	
	private TransCodeTypeEnum(String val) {
		this.val = val;
	}
}
