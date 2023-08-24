package com.keysoft.pigfarm.common;

public enum GoodsReceiptTransTypeEnum {
	GR_FROM_PO("1"), //nhap kho tu phieu PO (du lieu day xuong tu SAP chi co PO)
	GR_FROM_DO("2"), // nhap kho tu phieu DO.
	GR_OTHER("4");  //nhap kho kiem ke
	public String val;
	private  GoodsReceiptTransTypeEnum(String val) {
		this.val = val;
	}

}
