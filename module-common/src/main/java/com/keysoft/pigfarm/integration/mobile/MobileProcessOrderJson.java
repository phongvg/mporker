package com.keysoft.pigfarm.integration.mobile;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MobileProcessOrderJson {
	@JsonProperty("pigIdentifier")
	private String pigIdentifier;
	
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("transCode")
	private String transCode;
	
	@JsonProperty("barnCode")
	private String barnCode;
	
	@JsonProperty("pigType")
	private String pigType;
	
	@JsonProperty("quantity")
	private BigDecimal quantity;
	
	@JsonProperty("startDate")
	private String startDate;
	
	@JsonProperty("endDate")
	private String endDate;
	
	@JsonProperty("batch")
	private String batch;
	
	@JsonProperty("week")
	private Integer week;
	
	@JsonProperty("weekFromDate")
	private String weekFromDate;
	
	@JsonProperty("weekToDate")
	private String weekToDate;

	@JsonProperty("status")
	private String status;

	@JsonProperty("createdDate")
	private String createdDate;
	
	@JsonProperty("latest")
	private boolean latest;
	
	@JsonProperty("quotas")
	private List<MobileQuotaJson> quotas;
	
	@JsonProperty("realEndDate")
	private String realEndDate;
	
	@JsonProperty("realStartDate")
	private String realStartDate;
	
	@JsonProperty("realQuantity")
	private BigDecimal realQuantity;
	
	@JsonProperty("materialName")
	private String materialName;
	
	@JsonProperty("closedDate")
	private String closedDate;
}
