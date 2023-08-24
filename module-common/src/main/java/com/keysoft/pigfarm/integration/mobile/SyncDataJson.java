package com.keysoft.pigfarm.integration.mobile;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SyncDataJson {
	@JsonProperty("companies")
	private List<CompanyJson> companies;
	
	@JsonProperty("plants")
	private List<PlantJson> plants;
	
	@JsonProperty("farms")
	private List<FarmJson> farms;
	
	@JsonProperty("barns")
	private List<BarnJson> barns;
	
	@JsonProperty("materials")
	private List<MaterialJson> materials;
	
	@JsonProperty("stocks")
	private List<StockJson> stocks;
	
	@JsonProperty("instocks")
	private List<InstockJson> instocks;
	
	@JsonProperty("pigs")
	private List<PigJson> pigs;
	
	@JsonProperty("farmUsers")
	private List<FarmUserJson> farmUsers;
	
	@JsonProperty("barnPlans")
	private List<MobileBarnPlanJson> barnPlans;
	
	@JsonProperty("processOrders")
	private List<MobileProcessOrderJson> processOrders;
	
	@JsonProperty("purchaseRequisitions")
	private List<PurchaseRequisitionJson> purchaseRequisitions;
	
	@JsonProperty("goodsRequisitions")
	private List<GoodsRequisitionJson> goodsRequisitions;
	
	@JsonProperty("productions")
	private List<ProductionJson> productions;
	
	@JsonProperty("pigEntries")
	private List<PigEntryJson> pigEntryJsons;
	
	@JsonProperty("goodsReceipts")
	private List<GoodsReceiptJson> goodsReceipts;
	
	@JsonProperty("goodsIssues")
	private List<GoodsIssueJson> goodsIssues;
	
	@JsonProperty("systemParameters")
	private List<SystemParameterJson> systemParameters;
	
	@JsonProperty("otherCosts")
	private List<OtherCostJson> otherCosts;
	
	@JsonProperty("proposals")
	private List<ProposalJson> proposals;
	
	@JsonProperty("events")
	private List<EventJson> events;
	
	@JsonProperty("silos")
	private List<SiloJson> silos;
}
