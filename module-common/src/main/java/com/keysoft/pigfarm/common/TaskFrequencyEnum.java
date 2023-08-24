package com.keysoft.pigfarm.common;

public enum TaskFrequencyEnum {
		DAY("day"),
		WEEK("week"),
		MONTH("month"),
		ARISE("arise") // phat sinh
	;
	
	public String val;
	
	private TaskFrequencyEnum(String val) {
		this.val = val;
	}
}
