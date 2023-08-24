package com.keysoft.pigfarm.integration.sap;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class ProcessOrderJson {
	@JsonProperty("code")
	private String code ;
	
	@JsonProperty("pigtype")
	private String pigType;
	
	@JsonProperty("quantity")
	private java.math.BigDecimal quantity;
	
	@JsonProperty("startdate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate startDate;
	
	@JsonProperty("enddate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate endDate;
	
	@JsonProperty("batch")
	private String batch;
	
	@JsonProperty("barncode")
	private String barnCode;
	
	@JsonProperty("quotas")
	private List<QuotaJson> quotas;
	
	@JsonProperty("production_ver")
	private String productionVer;
}
