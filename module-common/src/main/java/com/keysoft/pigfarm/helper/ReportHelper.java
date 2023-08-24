package com.keysoft.pigfarm.helper;

public class ReportHelper {
	
	public final static Integer NUMBER_TO_CONVERT_UNIT = 2;
	
	// chuyển đổi đơn vị vật tư
	public static Integer convertMaterialUnit(String materialCode) {
		if (materialCode != null) {
			Integer materialCodeLength = materialCode.length();
			if (materialCodeLength > NUMBER_TO_CONVERT_UNIT) {
				Integer beginIndex = materialCodeLength - NUMBER_TO_CONVERT_UNIT;
				String unitToConvert = materialCode.substring(beginIndex);
				try {
					return Integer.parseInt(unitToConvert);
				} catch (Exception e) {
					return null;
				}
			}
		}
		return null;
	} 
	
}
