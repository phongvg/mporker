package com.keysoft.pigfarm.common;

public enum StockBalanceEventCodeEnum {
	GOODS_RECEIPT("goods_receipt"),
	GOODS_ISSUE("goods_issue"),
	GOODS_ISSUE_ADJUST_INCREA("goods_issue_adjust_increa"),
	PR_FROM_PIGFARM("pr_from_pigfarm"),
	GOODS_ATTRITIONS("goods_attritions");

	public String val;

	private StockBalanceEventCodeEnum(String val) {
		this.val = val;
	}
}
