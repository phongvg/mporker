package com.keysoft.pigfarm.common;

public enum GoodsIssueTypeEnum {
	GOODS_ISSUE("goods_issue"),
	TEMPLATE("template"),
	GOODS_ATTRITION("goods_attrition"),
	GOODS_ATTRITION_SUPPORT("goods_attrition_support"),
	PIG_ENTRY("pig_entry"),
	GI_FROM_SAP("gi_from_sap"),
	GI_FROM_PIGFARM("gi_from_pigfarm");

	public String val;

	private GoodsIssueTypeEnum(String val) {
		this.val = val;
	}
}
