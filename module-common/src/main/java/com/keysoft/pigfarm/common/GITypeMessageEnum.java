package com.keysoft.pigfarm.common;

public enum GITypeMessageEnum {
	GOODS_ISSUE_COMMON("Xuất kho chung"),		// xuat kho chung
	GOODS_ISSUE_INVENTORY("Xuất kiểm kê"),		// kiem ke
	GOODS_ISSUE_FUEL("Xuất nhiên liệu"),			// xuat nhien lieu
	GOODS_ISSUE("Xuất tiêu hao");				// xuat tieu hao

	public String val;

	private GITypeMessageEnum(String val) {
		this.val = val;
	}
}
