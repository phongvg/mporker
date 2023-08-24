package com.keysoft.pigfarm.common;

public enum SystemParamEnum {
	API_GATEWAY_URL("api-gateway-url"),
	API_SDP("api-sdp"),
	
	API_BUSINESS_PREFIX("api-business"),
	API_BUSINESS_PURCHASE_REQUISITION_PATTERN("api-business-purchase-requisition-pattern"),
	API_BUSINESS_CONFIRM_PROCESS_ORDER_PATTERN("api-business-confirm-process-order-pattern"),
	API_BUSINESS_CLOSED_PROCESS_ORDER_PATTERN("api-business-close-process-order-pattern"),
	API_BUSINESS_FINISH_PRODUCT_PATTERN("api-business-finish-product-pattern"),
	API_BUSINESS_PIG_ENTRY_PATTERN("api-business-pig-entry-pattern"),
	API_BUSINESS_BARN_PLAN_PATTER("api-business-barn-plan-pattern"),
	API_BUSINESS_GOODS_ATTRITION_PATTERN("api-business-goods-attrition-pattern"),
	API_BUSINESS_GOODS_ISSUE_GOODS_RECEIPT_PATTERN("api-business-goods-issue-goods-receipt-pattern"),
	API_BUSINESS_GENERAL_LEDGER_PATTERN("api-business-general-ledger-pattern"),

	API_MASTER_PREFIX("api-master"),
	API_MASTER_ORG_CHART_PATTERN("api-master-org-chart-pattern"),
	API_MASTER_WBS_PATTERN("api-master-wbs-pattern"),
	API_MASTER_MATERIAL_PATTERN("api-master-material-pattern"),
	API_SALES_DATA_PATTERN("api-master-sales-data-pattern"),
	
	LOCK_QUATITY_IN_QUOTA("lock-quantity-in-quota"),
	GOODS_ATTRITION_SUPPORT_PREFIX("goods-attrition-support"),
	GOODS_ATTRITION_SUPPORT_USE_QUANTITY_INSTOCK("goods-attrition-support-use-quantity-instock"),
	GOODS_ATTRITION_SUPPORT_LOCK_UPDATE_TOOL("goods-attrition-support-lock-update-tool"),
	GOODS_ATTRITION_SUPPORT_TIME_DISPLAY_PROCESS_ORDER("goods-attrition-support-time-display-process-order"),
	LOCK_SYNC_STOCK_COUNT("lock-sync-stock-count"),
	LOCK_IMPORT_DATA_INSTOCK("lock-import-data-instock"),
	LOCK_CONVERT_JSON_DATA("lock-convert-json-data"),
	LOCK_CONVERT_TO_JSON_DATA("lock-convert-to-json-data"),
	LOCK_SYNC_INSTOCK_DATA("lock-sync-instock-data"),
	LOCK_SYNC_INSTOCK_FROM_SAP_WITH_CODE_MAVIN("lock-sync-instock-from-sap-with-code-mavin"),
	MAPPING_MATERIAL_CODE_SYNC_INSTOCK_FROM_SAP("mapping-material-code-sync-instock-from-sap"),
	MAPPING_MATERIAL_CODE_PIG_ENTRY_PREFIX("mapping-material-code-pig-entry"),
	TIME_DELETE_SALES_DATA("time-delete-sales-data"),
	LOCK_INSTOCK_AFTER_CLONE_DATA("lock-instock-after-clone-data"),
	
	REPORT_INSTOCK_PIG_DATE_LIMIT("report-instock-pig-date-limit"),
	
	SDP_API_KEY("sdp-api-key"),
	INSTOCK_CLOSE_PERIOD("instock-close-period"),
	TASK_TURN_ON_OFF_SEND_MAIL("task-turn-on-off-send-mail"),
	TASK_DURATION_NOTIFICATION("task-duration-notification"),
	
	PROCESSORDER_CLOSE_CHECK("processorder-close-check"),
	
	DEFAULT_DOCUMENT_EMAIL("document-default-email"),
	DOCUMENT_DAYS_BEFORE_CANT_SAVE("document-days-before-cant-save")
	;
	
	public String param;

	private SystemParamEnum(String param) {
		this.param = param;
	}
}
