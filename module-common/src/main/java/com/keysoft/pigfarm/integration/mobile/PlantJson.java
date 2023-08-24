package com.keysoft.pigfarm.integration.mobile;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlantJson {
	@JsonProperty("companyCode")
	private String companyCode;
	
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("status")
	private String status;
}
