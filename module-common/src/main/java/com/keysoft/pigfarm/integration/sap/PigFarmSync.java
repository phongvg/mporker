package com.keysoft.pigfarm.integration.sap;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
public class PigFarmSync {
	// PurchaseRequisitions
	private List<PigfarmJson> purchaseRequisitionJsons = new ArrayList<>();
	// GoodsReceipts
	private List<PigfarmJson> goodsReceiptJsons = new ArrayList<>();
	// GoodsIssues
	private List<PigfarmJson> goodsIssueJsons = new ArrayList<>();
	// Goods Attrition
	private List<PigfarmJson> goodsAttritionJsons = new ArrayList<>();
	// BarnPlan
	private List<PigfarmJson> barnPlanJsons = new ArrayList<>();
	// process_Orders
	private List<PigfarmJson> processOrderJsons = new ArrayList<>();
	// goods issue, goods receipt
	private List<PigfarmJson> goodsIssueGoodsReceiptJsons = new ArrayList<>();
	// finish production
	private List<PigfarmJson> finishProductionJsons = new ArrayList<>();
	// pig entry
	private List<PigfarmJson> pigEntryJsons = new ArrayList<>();
	// closed process order
	private List<PigfarmJson> closedProcessOrderJsons = new ArrayList<>();
	// general ledger
	private List<PigfarmJson> generalLedgerJsons = new ArrayList<>();
}
