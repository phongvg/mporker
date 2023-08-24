package com.keysoft.pigfarm.production.json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class JsonPurchaseRequisition {
	@JsonProperty("prGroupCode")
	private String prGroupCode;
	
	@JsonProperty("prType")
	private String prType;
	
	@JsonProperty("requisitioner")
	private String requisitioner;
	
	@JsonProperty("deliveryDate")
	private String deliveryDate;
	
	@JsonProperty("plant")
	private String plant;
	
	@JsonProperty("materials")
	private List<JsonMaterial> materials = new ArrayList<>();
}
