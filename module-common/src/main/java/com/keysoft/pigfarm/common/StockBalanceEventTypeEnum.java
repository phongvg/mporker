package com.keysoft.pigfarm.common;

public enum StockBalanceEventTypeEnum {
	GOODS_RECEIPT("goods_receipt"),
	CLONE_INSTOCK("clone_instock"),
	GOODS_ISSUE("goods_issue"),
	GOODS_ATTRITION("goods_attrition"),
	GOODS_ISSUE_ADJUST_INCREA("goods_issue_adjust_increa"),
	INSTOCK_ADJUSTMENT("instock_adjustment"),
	SYNC_STOCK_COUNT("sync_stock_count"),
	PIG_ENTRY("pig_entry"),
	;

	public String val;

	private StockBalanceEventTypeEnum(String val) {
		this.val = val;
	}
}
