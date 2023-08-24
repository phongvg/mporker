package com.keysoft.pigfarm.common;

public enum MailEnum {
	TASK_SUBJECT("[MAVIN] Thông báo công việc"),
	DOCUMENT_SUBJECT("[MAVIN] FILE TÀI LIỆU")
	;
	
	public String val;
	
	private MailEnum(String val) {
		this.val = val;
	}
}
