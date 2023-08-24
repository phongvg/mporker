package com.keysoft.pigfarm.common;

public enum DayOfWeekEnum {
	MONDAY("MONDAY"),
	TUESDAY("TUESDAY"),
	WEDNESDAY("WEDNESDAY"),
	THURSDAY("THURSDAY"),
	FRIDAY("FRIDAY"),
	SATURDAY("SATURDAY"),
	SUNDAY("SUNDAY")
	;
	
	public String day;
	
	private DayOfWeekEnum(String day) {
		this.day = day;
	}
}
