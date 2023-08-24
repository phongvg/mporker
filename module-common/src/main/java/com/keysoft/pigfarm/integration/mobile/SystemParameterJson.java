package com.keysoft.pigfarm.integration.mobile;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class SystemParameterJson {
	@JsonProperty("paramName")
	private String paramName;
	
	@JsonProperty("paramValue")
	private String paramValue;
	
	@JsonProperty("description")
	private Integer description;
	
	@JsonProperty("version")
	private Integer version;
}
