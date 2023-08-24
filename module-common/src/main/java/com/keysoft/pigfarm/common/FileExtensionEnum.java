package com.keysoft.pigfarm.common;

public enum FileExtensionEnum {
	JPG("jpg"),
	JPEG("jpeg"),
	PNG("png"),
	PJP("pjp"),
	PJEP("pjpeg"),
	SVG("svg"),
	;
	
	public String val;
	
	private FileExtensionEnum(String val) {
		this.val = val;
	}
}
