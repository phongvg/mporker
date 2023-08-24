package com.keysoft.pigfarm.integration.mobile;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class GoodsReceiptJson {
	@JsonProperty("productionCode")
 	private String productionCode;
	
	//can thay doi theo Stock
	@JsonProperty("stockCode")
	private String stockCode;
	
	@JsonProperty("fromStockCode")
	private String fromStockCode;
	
	@JsonProperty("fromStockName")
	private String fromStockName;
	
	@JsonProperty("toStockCode")
	private String toStockCode;
	
	@JsonProperty("toStockName")
	private String toStockName;
	
	@JsonProperty("movementType")
	private String movementType;
	
	@JsonProperty("transCode")
	private String transCode;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("prCode")
	private String prCode;
	
	@JsonProperty("poCode")
	private String poCode;
	
	@JsonProperty("doCode")
  	private String doCode;
	
	@JsonProperty("grCode")
	private String grCode;
	
	@JsonProperty("customer")
	private String customer;
	
	@JsonProperty("vendor")
	private String vendor;
	
	@JsonProperty("vendorName")
	private String vendorName;
	
	//can thay doi theo LocalDate
	@JsonProperty("postingDate")
	private String postingDate;
	
	@JsonProperty("transType")
	private String transType;
	
	@JsonProperty("createdPerson")
	private String createdPerson;
	
	@JsonProperty("receivedPerson")
	private String receivedPerson;
	
	@JsonProperty("storekeeper")
	private String storekeeper;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("createdBy")
	private String createdBy;
	
	//can thay doi theo LocalDateTime
	@JsonProperty("createdDate")
	private String createdDate;
	
	@JsonProperty("modifiedBy")
	private String modifiedBy;
	
	//can thay doi theo LocalDateTime
	@JsonProperty("modifiedDate")
	private String modifiedDate;
	
	@JsonProperty("contents")
	private List<MaterialJson> contents;
	
	@JsonProperty("templateName")
	private String templateName;
	
	@JsonProperty("content")
	private String content;
	
	@JsonProperty("production")
 	private ProductionJson productionJson;
	
	@JsonProperty("contenProduction")
 	private String contenProduction;
}
