package com.keysoft.pigfarm.common;

public enum TypeEnum {
	PR_FROM_SAP("pr_from_sap"),
	PR_FROM_PIGFARM("pr_from_pigfarm");

	public String val;

	private TypeEnum(String val) {
		this.val = val;
	}
}
