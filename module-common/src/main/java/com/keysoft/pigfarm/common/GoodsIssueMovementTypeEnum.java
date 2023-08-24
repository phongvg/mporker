package com.keysoft.pigfarm.common;

public enum GoodsIssueMovementTypeEnum {
	GI_FROM_DO("641"),  // xuat kho tu phieu yeu cau
	GOODS_ISSUE("201"), // xuat kho chung
	GI_INVENTORY("Z09"), // kiem ke
	GI_FUEL("Z15"),// xuat nhien lieu
	GI_CULLED_PIG("551"); // Xuat huy heo
	
	public String val;
	private  GoodsIssueMovementTypeEnum(String val) {
		this.val = val;
	}
}
