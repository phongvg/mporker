package com.keysoft.pigfarm.common;

public enum WeightChartEnum {
	Pig_10_20("10-20"),
	Pig_20_30("20-30"),
	Pig_30_40("30-40"),
	Pig_40_50("40-50"),
	Pig_50_60("50-60"),
	Pig_60_70("60-70"),
	Pig_70_80("70-80"),
	Pig_80_90("80-90"),
	Pig_90_100("90-100"),
	Pig_100_110("100-110"),
	Pig_110_120("110-120");
	
	public String val;
	
	private WeightChartEnum(String val) {
		this.val = val;
	}
}
