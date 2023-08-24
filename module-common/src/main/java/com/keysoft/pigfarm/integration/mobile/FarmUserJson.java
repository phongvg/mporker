package com.keysoft.pigfarm.integration.mobile;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FarmUserJson {
	@JsonProperty("farmCode")
	private String farmCode;
	
	@JsonProperty("username")
	private String username;
}
