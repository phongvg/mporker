package com.keysoft.pigfarm.common;

public enum MapKeyEnum {
	MATERIALS("materials"),
	MATERIAL("material"),
	PIG_EVENT("pigEvent"),
	MATERIAL_CODE("materialCode"),
	WEIGHT("weight"),
	PIG_TYPE("pigType"),
	QUANTITY("quantity"),
	REASON("reason"),
	EVENT_CODE("eventCode"),
	EVENT_TYPE("eventType"),
	WEIGHT_NOTE("weightNote"),
	TOTAL_RETAINED("totalRetained"),
	RESULT("result"),
	MESSAGE("message"),
	CODE("code"),
	ERROR("error"),
	UNIT_CONVERSION("conversion"),
	USERNAME("username"),
	SELECTED_FARM_CODES("selectedFarmCodes"),
	JSON("json"),
	TRANS_CODE("transCode"),
	JSON_TYPE("jsonType"),
	PROCESS_ORDER_CODE("processOrderCode"),
	PURCHASING_GROUP("purchasingGroup"),
	WEIGHT_CHART("weightChart"),
	TRANS_CODES("transCodes"),
	;

	public String key;

	private MapKeyEnum(String key) {
		this.key = key;
	}
}
