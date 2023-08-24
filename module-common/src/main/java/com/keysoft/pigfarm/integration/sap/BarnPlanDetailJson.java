package com.keysoft.pigfarm.integration.sap;

import java.time.LocalDate;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonComponent
public class BarnPlanDetailJson {
	@JsonProperty("transcode")
  	private String transCode ;
	
	@JsonProperty("barncode")
  	private String barnCode ;
	
  	@JsonFormat(pattern="yyyyMMdd")
  	@DateTimeFormat(iso = ISO.DATE)
  	@JsonProperty("barnemptydate")
  	private LocalDate barnEmptyDate;
  	
	@JsonFormat(pattern="yyyyMMdd")
  	@DateTimeFormat(iso = ISO.DATE)
	@JsonProperty("realbarnemptydate")
  	private LocalDate realBarnEmptyDate;
	
	@JsonProperty("pigtype")
  	private String pigType;
	
	@JsonProperty("barnvolumn")
  	private Integer barnVolumn;
	
	@JsonProperty("realbarnvolumn")
  	private Integer realBarnVolumn;
}
