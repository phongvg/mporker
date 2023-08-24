package com.keysoft.pigfarm.common;

public enum GoodsRequisitionTypeEnum {
	GOODS_RECEIPT_REQUISITION("goods_receipt_requisition"),
	GOODS_ISSUE_REQUISITION("goods_issue_requisition"),
	PURCHASE_REQUISITION("purchase_requisition"),
	GOODS_ISSUE("goods_issue"),
	GOODS_ISSUE_INTERNAL("goods_issue_internal"),
	GOODS_ATTRITION("goods_attrition"),
	GOODS_RECEIPT("goods_receipt");

	public String val;

	private GoodsRequisitionTypeEnum(String val) {
		this.val = val;
	}
}
