package com.keysoft.pigfarm.helper;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class TransCodeHelper {
	private static final String PR = "PR"; //purchase requisition
	private static final String GR = "GR"; //goods receipt
	private static final String GI = "GI"; //goods issue
	private static final String BP = "BP"; //barn plan
	private static final String PO = "PO"; //process order
	private static final String EV = "EV"; //Event
	private static final String GA = "GA"; //goods attrition
	private static final String GS = "GS"; //goods requisition
	private static final String OC = "OC"; //other cost
	private static final String PP = "PP"; //proposal
	private static final String SL = "SL"; //Silo
	private static final String PE = "PE"; //PigEntry
	private static final String IN = "IN"; //Instock
	private static final String SC = "SC"; //Stock_Count
	private static final String I = "I"; //Material_TransCode_Item
	private static final String IA = "IA"; //instock adjustment
	private static final String IB = "IB"; //instock baseline
	private static final String IH = "IH"; //instock history
	private static final String GL = "GL"; // general ledger

	public String getGeneralLedgerTransCode() {
		return (new StringBuilder()).append(GL).append(RandomStringUtils.randomNumeric(8)).toString();
	}

	public String getPurchaseRequisitionTransCode() {
		return (new StringBuilder()).append(RandomStringUtils.randomNumeric(1)).append(PR).append(RandomStringUtils.randomNumeric(7)).toString();
	}
	
	public String getGoodsReceiptTransCode() {
		return (new StringBuilder()).append(RandomStringUtils.randomNumeric(1)).append(GR).append(RandomStringUtils.randomNumeric(7)).toString();
	}
	
	public String getGoodsIssueTransCode() {
		return (new StringBuilder()).append(RandomStringUtils.randomNumeric(1)).append(GI).append(RandomStringUtils.randomNumeric(7)).toString();
	}
	
	public String getBPTransCode() {
		return (new StringBuilder()).append(RandomStringUtils.randomNumeric(1)).append(BP).append(RandomStringUtils.randomNumeric(7)).toString();
	}
	
	public String getPOTransCode() {
		return (new StringBuilder()).append(RandomStringUtils.randomNumeric(1)).append(PO).append(RandomStringUtils.randomNumeric(7)).toString();
	}
	
	public String getEVTransCode() {
		return (new StringBuilder()).append(RandomStringUtils.randomNumeric(1)).append(EV).append(RandomStringUtils.randomNumeric(7)).toString();
	}
	
	public String getGoodsAttritionTransCode() {
		return (new StringBuilder()).append(RandomStringUtils.randomNumeric(1)).append(GA).append(RandomStringUtils.randomNumeric(7)).toString();
	}
	
	public String getGoodsRequisitionTransCode() {
		return (new StringBuilder()).append(RandomStringUtils.randomNumeric(1)).append(GS).append(RandomStringUtils.randomNumeric(7)).toString();
	}
	
	public String getOCTransCode() {
		return (new StringBuilder()).append(OC).append(RandomStringUtils.randomNumeric(8)).toString();
	}
	
	public String getPPTransCode() {
		return (new StringBuilder()).append(PP).append(RandomStringUtils.randomNumeric(8)).toString();
	}
	
	public String getSLTransCode() {
		return (new StringBuilder()).append(SL).append(RandomStringUtils.randomNumeric(8)).toString();
	}
	
	public String getPETransCode() {
		return (new StringBuilder()).append(RandomStringUtils.randomNumeric(1)).append(PE).append(RandomStringUtils.randomNumeric(7)).toString();
	}
	
	public String getInstockTransCode() {
		return (new StringBuilder()).append(RandomStringUtils.randomNumeric(1)).append(IN).append(RandomStringUtils.randomNumeric(7)).toString();
	}
	
	public String getStockCountTransCode() {
		return (new StringBuilder()).append(SC).append(RandomStringUtils.randomNumeric(8)).toString();
	}
	
	public String getMaterialItemTransCode() {
		return (new StringBuilder()).append(I).append(RandomStringUtils.randomNumeric(9)).toString();
	}
	
	public String getInstockAdjustmentTransCode() {
		return (new StringBuilder()).append(IA).append(RandomStringUtils.randomNumeric(8)).toString();
	}
	
	public String getInstockBaselineTransCode() {
		return (new StringBuilder()).append(IB).append(RandomStringUtils.randomNumeric(8)).toString();
	}
	
	public String getInstockHistoryTransCode() {
		return (new StringBuilder()).append(IH).append(RandomStringUtils.randomNumeric(8)).toString();
	}
	
}
