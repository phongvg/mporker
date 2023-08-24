package com.keysoft.pigfarm.common;

public enum HeaderKeyEnum {
	AUTHORIZATION("Authorization"),
	REALM("realm");
	
	public String key;
	
	private HeaderKeyEnum(String key) {
		this.key = key;
	}
}
