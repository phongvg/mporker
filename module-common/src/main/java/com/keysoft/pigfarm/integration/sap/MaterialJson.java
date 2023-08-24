package com.keysoft.pigfarm.integration.sap;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MaterialJson {
	@JsonProperty("MATNR")
	private String materialNumber;
	@JsonProperty("MATKL")
	private String materialGroupCode;
	@JsonProperty("MEINS")
	private String unit;
	@JsonProperty("NORMT")
	private String industryStandardDesc;
	@JsonProperty("XCHPF")
	private String batchManagement;
	@JsonProperty("MATKX")
	private String materialDesc;
	@JsonProperty("EKGRP")
	private String purchasingGroup;
	@JsonProperty("XMATNR")
	private String materialStatus;
	@JsonProperty("WGBEZ")
	private String materialGroupName;
	@JsonProperty("CONVERSION")
	private List<UnitConversionJson> unitConversions;
	@JsonProperty("BISMT")
	private String fastCode;
	@JsonProperty("LMATKX")
	private String description;
	
}
