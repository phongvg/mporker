package com.keysoft.pigfarm.common;

public enum DocumentStatusEnum {
	EMPTY("empty"),
	MAILSENT("email-sent"),
	SENDMAILFAILED("send-failed");

	public String val;

	private DocumentStatusEnum(String val) {
		this.val = val;
	}
}
