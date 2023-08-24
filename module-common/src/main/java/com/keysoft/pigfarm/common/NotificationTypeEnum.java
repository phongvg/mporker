package com.keysoft.pigfarm.common;

public enum NotificationTypeEnum {
    TASK("task"),
    WEIGHT_NOTE("weight_note"),
	PROCESS_ORDER_EVALUTE("process_order_evalute"),
	PROCESS_ORDER_CLOSE("process_order_close")
    ;

    public String type;

    private NotificationTypeEnum(String type) { this.type = type; }
}
