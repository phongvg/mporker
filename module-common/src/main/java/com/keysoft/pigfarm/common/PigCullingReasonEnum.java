package com.keysoft.pigfarm.common;

public enum PigCullingReasonEnum {
	SALE("Bán Loại"),
	SALE_FARM("Chọn bán thịt"),
	STOCK_MOVE("Chuyển trại (kho)"),
	;
	
	public String val;

	private PigCullingReasonEnum(String val) {
		this.val = val;
	}
}
