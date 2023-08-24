package com.keysoft.pigfarm.common;

public enum GoodsReceiptMovementTypeEnum {
	GOODS_RECEIPT("101"), //nhap kho tu phieu yeu cau
	INVENTORY("Z07"); // nhap kho kiem ke
	
	public String val;
	private  GoodsReceiptMovementTypeEnum(String val) {
		this.val = val;
	}
}
