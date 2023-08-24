package com.keysoft.pigfarm.integration.mobile;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ProductionJson {
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("processOrderCode")
	private String processOrderCode;
	
	@JsonProperty("feedDay")
	private Integer feedDay;
	
	//can thay doi truoc khi luu LocalDate
	@JsonProperty("feedDate")
	private String feedDate;  
	
	@JsonProperty("feedWeek")
	private Integer feedWeek;
	
	//can thay doi truoc khi luu LocalDate
	@JsonProperty("feedWeekStartDate")
	private String feedWeekStartDate;
	
	//can thay doi truoc khi luu LocalDate
	@JsonProperty("feedWeekToDate")
	private String feedWeekToDate;
	
	@JsonProperty("totalPig")
	private Integer totalPig;
	
	@JsonProperty("totalPigRetained")
	private Integer totalPigRetained;
	
	@JsonProperty("totalPigDead")
	private Integer totalPigDead;
	
	@JsonProperty("totalPigCulling")
	private Integer totalPigCulling;
	
	@JsonProperty("totalPigRelease")
	private Integer totalPigRelease;
	
	@JsonProperty("latest")
	private boolean latest;
	
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
	
	//can thay doi truoc khi luu LocalDate
	@JsonProperty("realStartDate")
	private String realStartDate;
}
