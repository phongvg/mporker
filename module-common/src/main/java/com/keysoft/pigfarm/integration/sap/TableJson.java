package com.keysoft.pigfarm.integration.sap;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class TableJson {
	@JsonProperty("name")
	private String name;
	@JsonProperty("item")
	private List<ItemJson> itemJsons;
}
