package com.keysoft.pigfarm.common;

public enum MaterialRecordTypeEnum {
	STOCK_COUNT("stock_count"),
	INSTOCK("instock"), 
	GOODS_ISSUE("goods_issue"),
	GOODS_RECEIPT("goods_receipt"), 
	STOCK_BALANCE("stock_balance"), 
	GOODS_REQUISITION("goods_requisition"),
	PURCHASE_REQUISITION("purchase_requisition"), 
	GOODS_ATTRITION_SUPPORT("goods_attrition_support"),
	GOODS_ATTRITION("goods_attrition"),
	INSTOCK_ADJUSTMENT("instock_adjustment"),
	EVENT("event"), 
	PIG_ENTRY("pig_entry"), 
	;
	
	public String val;
	private MaterialRecordTypeEnum(String val) {
		this.val = val;
	}
}
