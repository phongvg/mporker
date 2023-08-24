package com.keysoft.pigfarm.common;

public enum InstockAdjustmentTypeEnum {
	ADJUSTMENT_INCREASE("adjustment_increase"), //điều chỉnh tăng
	ADJUSTMENT_DECREASE("adjustment_decrease"),//điều chỉnh giảm
	IMPORT("import"),// import từ file excel 
	;
	
	public String val;
	private InstockAdjustmentTypeEnum(String val) {
		this.val = val;
	}
}
