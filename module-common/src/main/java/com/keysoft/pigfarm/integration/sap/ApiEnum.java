package com.keysoft.pigfarm.integration.sap;

public enum ApiEnum {
	PATH_ORG("org"),
	PATH_WBS("wbs"),
	PATH_MATERIAL("material"),
	PATH_PURCHASE_REQUISITION("purchase-requisition"),
	PATH_BARN_PLAN("barn-plan"),
	PATH_GOODS_ATTRITION("goods-attrition"),
	PATH_GOODS_ISSUE_GOODS_RECEIPT("goods-issue-goods-receipt"),
	PATH_FINISHED_PRODUCTION("finished-production"),
	PATH_CONFIRM_PROCESS_ORDER("confirm-process-order"),
	PATH_CLOSE_PROCESS_ORDER("close-process-order")
	;
	
	public String val;
	
	private ApiEnum(String val) {
		this.val = val;
	}
}
