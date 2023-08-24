package com.keysoft.pigfarm.common;

public enum TaskStatusEnum {
	ASSIGNED("assigned"),	
	CONFIRMED("confirmed"),
	EDITED("edited"),
	NEW("new"),
	REJECTED("rejected"),
	REASSIGNED("reassigned"),
	DONE("done")
	;
	
	public String val;
	
	private TaskStatusEnum(String val) {
		this.val = val;
	}
}
