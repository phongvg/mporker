package com.keysoft.pigfarm.common;

public enum MaterialPigTypeEnum {
	MAVIN134("MAVIN134"),  // ba mau
	MAVIN132("MAVIN132"),  // hai mau
	MAVIN130("MAVIN130"),   // hai mau
	MAVIN132_00("MAVIN132-00"),
	MAVIN130_01("MAVIN130-01"),
	MAVIN130_00("MAVIN130-00"),
	MAVIN134_00("MAVIN134-00"),
	MAVIN133("MAVIN133"),
	MAVIN132_V0("MAVIN132-V0"),
	MAVIN134_V0("MAVIN134-V0")
	
	;
	public String val;
	private MaterialPigTypeEnum(String val) {
		this.val = val;
	}
}
