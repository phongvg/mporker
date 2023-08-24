package com.keysoft.pigfarm.common;

public enum FunctionTypeEnum {
	BARN_PLAN("barn_plan"),
	PROCESS_ORDER("process_order"),
	PIG_ENTRY("pig_entry"),
	PRODUCTION("production"),
	EVENT("event"),
	GOODS_ISSUE("goods_issue"),
	GOODS_ATTRITION("goods_attrition"),
	GOODS_RECEIPT("goods_receipt"),
	GOODS_REQUISITION("goods_requisition"),
	PURCHASE_REQUISITION("purchase_requisition"),
	OTHER_COST("other_cost"),
	PIG("pig"),
	INSTOCK("instock"),
	PROPOSAL("proposal"),
	SILO("silo"),
	CLOSED_PROCESS_ORDER("closed_process_order"),
	CLOSE_PERIOD("close_period"),
	CLOSE_GOODSATTRITION("close_ga"),
	EVIDENCE("evidence"),
	GENERAL_LEDGER("general_ledger")
	;
	
	public String type;
	
	private FunctionTypeEnum(String type) {
		this.type = type;
	}
}
