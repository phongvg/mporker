package com.keysoft.pigfarm.production.json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class JsonGoodsReceipt {
	@JsonProperty("stockCode")
	private String stockCode;
	
	@JsonProperty("prCode")
	private String prCode;
	
	@JsonProperty("poCode")
	private String poCode;
	
	@JsonProperty("movementType")
	private String movementType;
	
	@JsonProperty("postingDate")
	private String postingDate;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("materials")
	private List<JsonMaterial> materials = new ArrayList<>();
}
