package com.keysoft.pigfarm.integration.mobile;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ProposalJson {
	@JsonProperty("processOrderCode")
	private String processOrderCode;
	
	@JsonProperty("transCode")
	private String transCode;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("pigType")
	private String pigType;
	
	//can thay doi truoc khi luu LocalDate
	@JsonProperty("recordDate")
	private String recordDate;
	
	@JsonProperty("farmCode")
	private String farmCode;
	
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
