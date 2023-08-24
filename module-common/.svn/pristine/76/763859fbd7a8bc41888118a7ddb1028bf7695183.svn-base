package com.keysoft.pigfarm.production.json;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class JsonMaterial {
	
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("groupname")
	private String groupName;
	
	@JsonProperty("groupcode")
	private String groupCode;
	
	@JsonProperty("quantity")
	private BigDecimal quantity;
	
	@JsonProperty("unit")
	private String unit;
	
	@JsonProperty("batch")
	private String batch;
	
	@JsonProperty("grossweight")
	private BigDecimal grossWeight;
	
	@JsonProperty("weightunit")
	private String weightUnit;
	
	@JsonProperty("manufactureddate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
	private LocalDate manufacturedDate;
	
	@JsonProperty("expireddate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
	private LocalDate expiredDate;
	
	@JsonProperty("orderunit")
 	private String orderUnit;
	
	@JsonProperty("deliverydate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
	private LocalDate deliveryDate;
	
	@JsonProperty("itemnum")
	private String itemNum;
}
