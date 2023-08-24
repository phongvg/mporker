package com.keysoft.pigfarm.integration.mobile;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EventJson {
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("contents")
	private ContentEventJson contentEventJson;
	
	@JsonProperty("createdBy")
	private String createdBy;
	
	@JsonProperty("createdDate")
	private String createdDate;
	
	@JsonProperty("modifiedBy")
	private String modifiedBy;
	
	@JsonProperty("modifiedDate")
	private String modifiedDate;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("transCode")
	private String transCode;
	
	@JsonProperty("productionCode")
	private String productionCode;
	
	@JsonProperty("production")
	private ProductionJson productionJson;
	
	@JsonProperty("content")
	private String content;
}
