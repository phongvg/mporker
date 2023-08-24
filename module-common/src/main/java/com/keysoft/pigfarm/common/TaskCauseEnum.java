package com.keysoft.pigfarm.common;

public enum TaskCauseEnum {
	ADDITIONAL("Đã bổ sung tệp tin"),
	DONE("Hoàn thành công việc")
	;
	
	public String val;
	
	private TaskCauseEnum(String val) {
		this.val = val;
	}
}
