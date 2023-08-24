package com.keysoft.pigfarm.common;

public enum GoodsIssueTransTypeEnum {
	GI_FROM_DO("3"),
	GI_CULLED_PIG("6"),
	GI_OTHER("5");
	
	public String val;
	private  GoodsIssueTransTypeEnum(String val) {
		this.val = val;
	}
}
