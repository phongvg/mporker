package com.keysoft.pigfarm.common;

public enum NumberEnum {
	FIRST_FEED_DAY(1),
	FIRST_FEED_WEEK(2),
	PIG_DEAD(0),
	;
	public int val;

	private NumberEnum(int number) {
		this.val = number;
	}
}
