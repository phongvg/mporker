package com.keysoft.pigfarm.integration.mobile;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InstockJson {
	@JsonProperty("stockCode")
	private String stockCode;
	
	@JsonProperty("contents")
	private List<MaterialJson> contents = new ArrayList<>();
	
	@JsonProperty("syncDate")
	private String syncDate;
	
	@JsonProperty("createdDate")
	private String createdDate;
	
	@JsonProperty("latest")
	private boolean latest;
}