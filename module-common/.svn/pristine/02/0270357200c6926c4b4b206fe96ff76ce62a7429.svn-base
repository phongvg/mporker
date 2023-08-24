package com.keysoft.pigfarm.integration.mobile;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SiloJson {
	@JsonProperty("amount")
	private BigDecimal amount;
	
	@JsonProperty("barnCode")
	private String barnCode;
	
	@JsonProperty("transCode")
	private String transCode;
	
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
	
	@JsonProperty("contents")
	private List<ContentProposalJson> contents;
	
	@JsonProperty("content")
	private String content;
}
