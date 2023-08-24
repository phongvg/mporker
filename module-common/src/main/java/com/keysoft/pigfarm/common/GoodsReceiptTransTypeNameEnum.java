package com.keysoft.pigfarm.common;

public enum GoodsReceiptTransTypeNameEnum {
	GOODS_RECEIPT_PO("Nhập từ PO"),
	GOODS_RECEIPT_DO("Nhập từ DO"),
	GOODS_RECEIPT_Z07("Kiểm kê");
	
	public String val;
	private GoodsReceiptTransTypeNameEnum(String val) {
		this.val = val;
	}
}
