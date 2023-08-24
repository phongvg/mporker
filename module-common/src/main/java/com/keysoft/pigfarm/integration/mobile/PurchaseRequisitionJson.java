package com.keysoft.pigfarm.integration.mobile;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PurchaseRequisitionJson {
	@JsonProperty("transCode")
	private String transCode;
	
	@JsonProperty("prGroupCode")
	private String prGroupCode;
	
	//can thay doi truoc khi luu Stock
	@JsonProperty("stockCode")
	private String stockCode;
	
	@JsonProperty("prCode")
	private String prCode;
	
	@JsonProperty("prType")
	private String prType;
	
	@JsonProperty("requisitioner")
	private String requisitioner;
	
	@JsonProperty("contents")
	private List<MaterialJson> contents;
	
	@JsonProperty("plant")
	private String plant;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("createdBy")
	private String createdBy;
	
	//can thay doi truoc khi luu LocalDateTime
	@JsonProperty("createdDate")
	private String createdDate;
	
	@JsonProperty("modifiedBy")
	private String modifiedBy;
	
	//can thay doi truoc khi luu LocalDateTime
	@JsonProperty("modifiedDate")
	private String modifiedDate;
	
	@JsonProperty("content")
	private String content;
}
