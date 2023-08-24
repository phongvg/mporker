package com.keysoft.pigfarm.common;

public enum GITypeEnum {
	GOODS_ISSUE_COMMON("1"),		// xuat kho chung
	GOODS_ISSUE_INVENTORY("2"),		// kiem ke
	GOODS_ISSUE_FUEL("3"),			// xuat nhien lieu
	GOODS_ISSUE("4");				// xuat tieu hao

	public String val;

	private GITypeEnum(String val) {
		this.val = val;
	}
}
