package com.keysoft.pigfarm.common;

public enum MinusMonthEnum {
	ONE(1),
	TWO(2),
	THREE(3);
	
	public Integer val;
	
	private MinusMonthEnum(Integer number) {
		this.val = number;
	}
}
