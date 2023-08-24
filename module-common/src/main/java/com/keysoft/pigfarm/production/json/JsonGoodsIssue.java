package com.keysoft.pigfarm.production.json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class JsonGoodsIssue {
	@JsonProperty("stockCode")
	private String stockCode;
	
	@JsonProperty("doCode")
	private String doCode;
	
	@JsonProperty("costCenter")
	private String costCenter;
	
	@JsonProperty("reason")
	private String reason;
	
	@JsonProperty("plant")
	private String plant;
	
	@JsonProperty("movementType")
	private String movementType;
	
	@JsonProperty("postingDate")
	private String postingDate;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("customer")
	private String customer;
	
	@JsonProperty("materials")
	private List<JsonMaterial> materials = new ArrayList<>();
}
