package com.keysoft.pigfarm.integration.mobile;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PigEntryJson {
	@JsonProperty("processOrderCode")
	private String processOrderCode;
	
	//can thay doi truoc khi luu LocalDate
	@JsonProperty("entryDate")
	private String entryDate;  
	
	//can thay doi truoc khi luu LocalDate
	@JsonProperty("matureDate")
	private String matureDate;
	
	@JsonProperty("sourceFarm")
	private String sourceFarm;
	
	@JsonProperty("receiveFarm")
	private String receiveFarm;
	
	@JsonProperty("quantity")
	private Integer quantity;
	
	@JsonProperty("totalEntryVolumn")
	private BigDecimal totalEntryVolumn;
	
	@JsonProperty("averageVolume")
	private BigDecimal averageVolume;
	
	@JsonProperty("ageWeek")
	private Integer ageWeek;
	
	//can thay doi truoc khi luu Pig
	@JsonProperty("pigIdentifier")
	private String pigIdentifier;
	
	@JsonProperty("transCode")
	private String transCode;
}
