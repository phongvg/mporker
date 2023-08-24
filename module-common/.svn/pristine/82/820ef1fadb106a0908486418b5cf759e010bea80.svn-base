package com.keysoft.pigfarm.helper;

import org.apache.commons.lang3.StringUtils;

public class MaterialCodeConvertHelper {
	private MaterialCodeConvertHelper() {
		throw new IllegalStateException("MaterialConvertCode class");
	}
	
	public static String convertToCode18Char(String code) {
		if (StringUtils.isNumeric(code.trim())) {
			StringBuilder builder = new StringBuilder();
	    	Integer length = 18 - code.length();
	    	if(length > 0) {
	    		for (int i = 0; i < length; i++) {
		    		builder.append("0");
		    	}
		    	builder.append(code);
		    	return builder.toString();
	    	} else {
	    		return code;
	    	}
		} else {
			return code;
		}
	}
	
	public static String convertToCodeNumber(String code) {
		if (StringUtils.isNumeric(code.trim())) {
			Long materialCodeNumber = Long.parseLong(code);
	    	return materialCodeNumber.toString();
		} else {
			return code;
		}
	}
}
