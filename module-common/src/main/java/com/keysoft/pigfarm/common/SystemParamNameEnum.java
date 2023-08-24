package com.keysoft.pigfarm.common;

/**
 * The Enum RequestParamEnum.
 *
 * @author <a href="mailto:ngtrungkien@gmail.com">Kien Nguyen</a>
 */
public enum SystemParamNameEnum {
	DATASOURCE("data-source"),
	SAP_URL("sap-url"),
	;
	
	public String param;

	private SystemParamNameEnum(String param) {
		this.param = param;
	}
}
