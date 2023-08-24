package com.keysoft.pigfarm.integration.sap;


import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class QuotaJson {
	@JsonProperty("day")
	private Integer day;
	
	@JsonProperty("materialcode")
  	private String materialCode;
	
	@JsonProperty("materialname")
  	private String materialName;
	
	@JsonProperty("quantity")
  	private Integer quantity;
	
	@JsonProperty("batch")
 	private String batch ;
	
	@JsonProperty("unit")
 	private String unit ;
	
	@JsonProperty("requestdate")
  	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
 	private LocalDate requestDate;
	
	@JsonProperty("manufactureddate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
 	private LocalDate  manufacturedDate;	
	
	@JsonProperty("expireddate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
	private LocalDate  expiredDate;

}
